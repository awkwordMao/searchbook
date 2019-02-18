package cn.jl.searchbook.service.imp;

import cn.jl.searchbook.dao.BookDao;
import cn.jl.searchbook.model.Book;
import cn.jl.searchbook.service.BookService;
import cn.jl.searchbook.utils.HttpUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookServiceImp implements BookService {

    @Autowired
    private BookDao bookDao;

    @Override
    public List<Book> search(String name) {
        List<Book> resultList = new ArrayList<>();
        resultList = HttpUtils.getBooks(name);
        if(resultList != null && resultList.size() > 0){
            bookDao.saveAll(resultList);
        }
        return resultList;
    }
}
