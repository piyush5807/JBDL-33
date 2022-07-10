package com.example.minor1.services;

import com.example.minor1.exceptions.TxnServiceException;
import com.example.minor1.models.Book;
import com.example.minor1.models.Student;
import com.example.minor1.models.Transaction;
import com.example.minor1.models.TransactionType;
import com.example.minor1.repositories.TransactionRepository;
import com.example.minor1.request.BookFilterType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Service
public class TxnService {

    private static Logger logger = LoggerFactory.getLogger(TxnService.class);

    @Autowired
    StudentService studentService;

    @Autowired
    BookService bookService;

    @Autowired
    TransactionRepository transactionRepository;

    @Value("${book.return.due_date}")
    int number_of_days;

    // 30
//    @Transactional
    public String issueTxn(int studentId, int bookId) throws TxnServiceException, InterruptedException {
        /**
         * Student is a valid entity
         * Book is present and is available
         * Create a transaction --> saving in the txn table
         * Make the book unavailable
         */

        logger.info("Issue request came: studentId - {}, bookId - {}", studentId, bookId);

//        Transaction dummyTxn = Transaction.builder()
//                .externalTxnId(UUID.randomUUID().toString())
//                .transactionType(TransactionType.DUMMY)
//                .build();
//
//        transactionRepository.save(dummyTxn) ;

//        Thread.sleep(10000);

//        logger.info("After sleeping in Issue request came: studentId - {}, bookId - {}", studentId, bookId);

        Student student = studentService.findStudentByStudentId(studentId);

        if(student == null){
            throw new TxnServiceException("Student not present in the library");
        }

        List<Book> books = bookService.find(BookFilterType.BOOK_ID, String.valueOf(bookId));
        if(books == null || books.size() != 1 || books.get(0).getStudent() != null){
            throw new TxnServiceException("Book not present in the library");
        }

        Transaction transaction = Transaction.builder()
                .externalTxnId(UUID.randomUUID().toString())
                .transactionType(TransactionType.ISSUE)
                .payment(books.get(0).getCost())
                .book(books.get(0))
                .student(student)
                .build();

        transactionRepository.save(transaction);

        //

        books.get(0).setStudent(student);
        bookService.createOrUpdate(books.get(0));

        return transaction.getExternalTxnId();

    }

    public String returnTxn(int studentId, int bookId) throws TxnServiceException {

        /**
         * Student is a valid entity
         * Book is issued to this particular student
         * Calculate the fine
         * Create a transaction --> saving in the txn table
         * Make the book available
         */


        Student student = studentService.findStudentByStudentId(studentId);

        if(student == null){
            throw new TxnServiceException("Student not present in the library");
        }

        List<Book> books = bookService.find(BookFilterType.BOOK_ID, String.valueOf(bookId));
        if(books == null || books.size() != 1){
            throw new TxnServiceException("Book not present in the library");
        }

        if(books.get(0).getStudent().getId() != studentId){
            throw new TxnServiceException("Book not issued to this student");
        }

        // Finding the original issue Txn
        /*
        select * from transaction
        where my_book_id = ? and student_id = ? and transaction_type = 'ISSUE' ORDER BY transaction_date DESC;
        */

        Transaction issueTxn = transactionRepository
                .findTopByBookAndStudentAndTransactionTypeOrderByIdDesc(books.get(0), student, TransactionType.ISSUE);

        logger.info("issueTxn date - {}, txnId - {}", issueTxn.getTransactionDate(), issueTxn.getId());

        Transaction transaction = Transaction.builder()
                .transactionType(TransactionType.RETURN)
                .externalTxnId(UUID.randomUUID().toString())
                .book(books.get(0))
                .student(student)
                .payment(calculateFine(issueTxn))
                .build();

        transactionRepository.save(transaction);

        books.get(0).setStudent(null);
        bookService.createOrUpdate(books.get(0));
        return transaction.getExternalTxnId();
    }

    private double calculateFine(Transaction issueTxn){
        long issueTime = issueTxn.getTransactionDate().getTime();
        long returnTime = System.currentTimeMillis();

        long diff = returnTime - issueTime;
        long daysPassed = TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);


        if(daysPassed >= number_of_days) {
            return (daysPassed - number_of_days) * 1.0;
        }

        return 0.0;
    }
}
