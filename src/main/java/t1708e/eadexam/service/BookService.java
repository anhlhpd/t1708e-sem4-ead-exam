package t1708e.eadexam.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import t1708e.eadexam.entity.Book;
import t1708e.eadexam.repository.BookRepository;

import java.util.List;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;

    public List<Book> books() {
        //bookRepository.findAll(PageRequest.of(1, 3));
        return bookRepository.findAll();
    }

    public Book getById(int id) {
        return bookRepository.findById(id).orElse(null);
    }
    public Book getByName(String name){
        return bookRepository.getByName(name);
    }

    public Book create(Book book) {
        return bookRepository.save(book);
    }

}
