package t1708e.eadexam.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import t1708e.eadexam.entity.Book;
import t1708e.eadexam.repository.BookRepository;

import java.util.List;

@Service
public class BookService {

    @Autowired
    @Qualifier("bookRepository")
    BookRepository bookRepository;

    public List<Book> books() {
        //bookRepository.findAll(PageRequest.of(1, 3));
        return bookRepository.findAll();
    }

    public Book getById(int id) {
        return bookRepository.findById(id).orElse(null);
    }
    public Book search(String keyword){
        return bookRepository.getByNameOrAuthorOrGenre(keyword, keyword, keyword);
    }

    public Book create(Book book) {
        return bookRepository.save(book);
    }

}
