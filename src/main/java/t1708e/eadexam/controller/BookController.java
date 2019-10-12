package t1708e.eadexam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import t1708e.eadexam.entity.Book;
import t1708e.eadexam.service.BookService;

import java.util.List;

@Controller
@RequestMapping(value = "/books")
public class BookController {

    @Autowired
    BookService bookService;

    @RequestMapping(method = RequestMethod.GET)
    public String index(Model model) {
        List<Book> books = bookService.books();
        model.addAttribute("books", books);
        return "book/index";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public String detail(@PathVariable int id, Model model) {
        Book book = bookService.getById(id);
        if (book == null) {
            return "error/404";
        }
        model.addAttribute("book", book);
        return "book/detail";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/create")
    public String create(Model model) {
        model.addAttribute("book", new Book());
        return "book/form";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/search")
    public String list(){
        return "book/search";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/search")
    public String search(@PathVariable String keyword, Model model){
        model.addAttribute("book", bookService.search(keyword));
        return "book/search";
    }
}
