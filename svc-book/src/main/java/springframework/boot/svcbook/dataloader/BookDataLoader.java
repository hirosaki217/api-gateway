package springframework.boot.svcbook.dataloader;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import springframework.boot.svcbook.model.Book;
import springframework.boot.svcbook.service.BookService;

//@Component
//public class BookDataLoader implements ApplicationRunner {
//
//    private BookService bookService;
//
//    @Autowired
//    public BookDataLoader(BookService bookService) {
//        this.bookService = bookService;
//    }
//
//    @Override
//    public void run(ApplicationArguments applicationArguments) throws Exception {
//        this.bookService.createBook(new Book("Aldous Huxley", "Lap trinh di dong"));
//        this.bookService.createBook(new Book("George Orwell", "Lap trinh web"));
//    }
//}