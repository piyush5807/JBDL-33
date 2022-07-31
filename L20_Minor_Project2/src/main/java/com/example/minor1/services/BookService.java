package com.example.minor1.services;

import com.example.minor1.models.Author;
import com.example.minor1.models.Book;
import com.example.minor1.models.Genre;
import com.example.minor1.repositories.AuthorRepository;
import com.example.minor1.repositories.BookRepository;
import com.example.minor1.request.BookCreateRequest;
import com.example.minor1.request.BookFilterType;
import com.example.minor1.request.BookSearchOperationType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    AuthorRepository authorRepository;

    public void createOrUpdate(BookCreateRequest bookCreateRequest){
        Book book = bookCreateRequest.to();
        createOrUpdate(book);
    }

    public void createOrUpdate(Book book){
        Author author = book.getAuthor();

        // Find if the author with the given email exists in db or not ??
        // If exists, then don't save, else save it in the db first
        Author authorFromDB = authorRepository.findByEmail(author.getEmail());

        if(authorFromDB == null){
            authorFromDB = authorRepository.save(author);
        }

        // select * from author where email = ?

//        author.setId(1);
//        book.setAuthor(author);  // Not required

        book.setAuthor(authorFromDB);
        bookRepository.save(book);
    }

    public List<Book> find(BookFilterType bookFilterType, String value){

        switch (bookFilterType){
            case NAME:
                return bookRepository.findByName(value);
            case AUTHOR_NAME:
                return bookRepository.findByAuthor_Name(value);
            case GENRE:
                return bookRepository.findByGenre(Genre.valueOf(value));
            case BOOK_ID:
                return bookRepository
                        .findAllById(Collections.singletonList(Integer.parseInt(value)));
            default:
                return new ArrayList<>();
        }
    }

    public List<Book> find2(BookFilterType bookFilterType,
                            String value,
                            BookSearchOperationType bookSearchOperationType){

        // TODO: Modify this function
        switch (bookFilterType){
            case NAME:
                return bookRepository.findByName(value);
            case AUTHOR_NAME:
                return bookRepository.findByAuthor_Name(value);
            case GENRE:
                return bookRepository.findByGenre(Genre.valueOf(value));
            default:
                return new ArrayList<>();
        }
    }

    public List<Book> find3(List<BookFilterType> bookFilterType,
                            List<String> value,
                            List<BookSearchOperationType> bookSearchOperationType){

        // findEqualsGeneric --> select b from Book b where ?1 = ?1
//        List<Book> books = IntStream.range(0, bookFilterType.size())
//                .filter(i -> bookSearchOperationType.get(i) == BookSearchOperationType.EQUALS)
//                        .mapToObj(i -> bookRepository.findEqualsGeneric(bookFilterType.get(i), value.get(i)))
//                .collect(Collectors.toList());
//


        // TODO: Modify this function
//        switch (bookFilterType){
//            case NAME:
//                return bookRepository.findByName(value);
//            case AUTHOR_NAME:
//                return bookRepository.findByAuthor_Name(value);
//            case GENRE:
//                return bookRepository.findByGenre(Genre.valueOf(value));
//            default:
//                return new ArrayList<>();
//        }

        return null;
    }



}
