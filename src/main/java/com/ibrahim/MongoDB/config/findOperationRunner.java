package com.ibrahim.MongoDB.config;

import java.util.List;
import com.ibrahim.MongoDB.entity.Book;
import com.ibrahim.MongoDB.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class findOperationRunner implements CommandLineRunner {

    @Autowired
    private BookRepository bookRepo;

    @Override
    public void run(String... args) throws Exception {

        // findAll() : It will retrieve all records saved into DB
        List<Book> bookList = bookRepo.findAll();
        bookList.forEach(System.out::println);     // Printing all saved books
    }

   //Optional<Book> opt = bookRepo.findById("ISBN10:1484240251");
   //if(opt.isPresent())

   //{
   //    Book b1 = opt.get();
   //    System.out.println("Here is the book details : " + b1);
   //} else

   //{
   //    System.out.println("Given Id not found");
   //}

   //bookRepo.deleteById("ISBN10:1484240251");    // Delete Book of a particular Id
   //bookRepo.deleteAll();               // Deleting all books
}