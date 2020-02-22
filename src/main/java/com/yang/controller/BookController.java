package com.yang.controller;

import com.yang.pojo.Book;
import com.yang.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {
    //controller调service层
    @Autowired
    @Qualifier("BookServiceImpl")
    private BookService bookService;

    //查询全部的书籍，并且返回到一个书籍展示页面
    @RequestMapping("/allBook")
    public String list(Model model){
        List<Book> list=bookService.queryAllBook();

        model.addAttribute("list",list);
        return "allBook";
    }

    //跳转到增加书籍页面
    @RequestMapping("/toAddBook")
    public String toAddPaper(){
        return "addBook";
    }

    //添加书籍
    @RequestMapping("/addBook")
    public String addBook(Book book){
        bookService.addBook(book);
        return "redirect:/book/allBook";//重定向
    }

    @RequestMapping("/toUpdate")
    public String toUpdatePager(int id,Model model){
        Book book=bookService.queryBookById(id);//先由Id得到书籍信息
        model.addAttribute("Qbook",book);//保存到model中
        return "updateBook";
    }
    @RequestMapping("/updateBook")
    public  String updateBook(Book book){
        bookService.updateBook(book);
        return "redirect:/book/allBook";
    }

    @RequestMapping("/deleteBook/{bookId}")
    public String deleteBook(@PathVariable("bookId") int id){
        bookService.deleteBookById(id);
        return "redirect:/book/allBook";
    }
}
