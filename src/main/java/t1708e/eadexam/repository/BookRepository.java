package t1708e.eadexam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import t1708e.eadexam.entity.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {

    Book getByName(String name);
}
