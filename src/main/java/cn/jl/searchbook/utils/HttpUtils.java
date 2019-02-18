package cn.jl.searchbook.utils;

import cn.jl.searchbook.model.Book;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HttpUtils {
    public static final String SEARCH_URL = "https://search.jd.com/Search?keyword=";

    public static List<Book> getBooks(String name){
        List<Book> resultList = new ArrayList<>();
        try {
            Connection.Response response = Jsoup.connect(SEARCH_URL + name).method(Connection.Method.GET).execute();
            if(response.statusCode() == 200){
                resultList = parse(response.body());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return resultList;
    }

    public static List<Book> parse(String response){
        List<Book> resultList = new ArrayList<>();
        Document document = Jsoup.parse(response);
        Elements elements = document.select("ul[class=gl-warp clearfix]").select("li[class=gl-item]");
        if(elements != null && elements.size() > 0){
            for(Element element : elements){
                Book book = new Book();
                String bookId = element.attr("data-sku");
                String price = element.select("div[class=p-price]").select("strong").select("i").text();
                String titile = element.select("div[class=p-name]").select("a").select("em").text();
                String comment = element.select("div[class=p-commit]").select("strong").select("a").text();
                System.out.println("titile:"+titile);
                book.setId(bookId);
                book.setBookName(titile);
                book.setPrice(price);
                resultList.add(book);

            }
        }
        return resultList;
    }

}
