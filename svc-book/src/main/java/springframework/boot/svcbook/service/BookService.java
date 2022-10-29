package springframework.boot.svcbook.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;



import springframework.boot.svcbook.exception.BookNotFoundException;
import springframework.boot.svcbook.model.Book;
import springframework.boot.svcbook.repository.BookRepository;

@Service
@Transactional(readOnly = true)
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<Book> findAllBooks() {
        return bookRepository.findAll();
    }

    public Optional<Book> findBookById(Long bookId) {
        return Optional.ofNullable(bookRepository.findById(bookId))
            .orElseThrow(() -> new BookNotFoundException("Book not found. ID: " + bookId));
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public Book createBook(Book book) {
        final Book newBook = new Book();
        newBook.setTitle(book.getTitle());
        newBook.setAuthor(book.getAuthor());
        return bookRepository.save(newBook);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void deleteBook(Long bookId) {
        bookRepository.deleteById(bookId);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public Book updateBook(Map<String, String> updates, Long bookId) {
        final Optional<Book> book = findBookById(bookId);
        updates.keySet()
            .forEach(key -> {
                switch (key) {
                case "author":
                    book.get().setAuthor(updates.get(key));
                    break;
                case "title":
                    book.get().setTitle(updates.get(key));
                }
            });
        return bookRepository.save(book.get());
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public Book updateBook(Book book, Long bookId) {

        return bookRepository.save(book);
    }
}