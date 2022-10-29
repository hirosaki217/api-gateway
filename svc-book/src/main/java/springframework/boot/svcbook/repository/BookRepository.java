package springframework.boot.svcbook.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import springframework.boot.svcbook.model.Book;

public interface BookRepository extends JpaRepository<Book, Long>{
}
