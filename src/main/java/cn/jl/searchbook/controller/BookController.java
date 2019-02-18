package cn.jl.searchbook.controller;

import cn.jl.searchbook.model.Book;
import cn.jl.searchbook.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(){
        System.out.println("hello");
        return "index";
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String searchBook(Model model, @RequestParam(name = "bookName") String name){

        List<Book> bookList =  bookService.search(name);
        model.addAttribute("bookList", bookList);
        return "result";
    }
}
