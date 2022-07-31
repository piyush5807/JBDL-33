package com.example.minor1.repositories;

import com.example.minor1.models.Book;
import com.example.minor1.models.Student;
import com.example.minor1.models.Transaction;
import com.example.minor1.models.TransactionType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {

    Transaction findTopByBookAndStudentAndTransactionTypeOrderByIdDesc(
            Book book,Student student, TransactionType transactionType
    );

}
