package cn.jl.searchbook.dao;

import cn.jl.searchbook.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BookDao extends JpaRepository<Book, String> {

}
