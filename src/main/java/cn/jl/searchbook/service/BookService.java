package cn.jl.searchbook.service;

import cn.jl.searchbook.model.Book;
import org.springframework.stereotype.Service;

import java.util.List;


public interface BookService {

    List<Book> search(String name);
}
