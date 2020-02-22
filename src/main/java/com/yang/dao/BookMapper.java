package com.yang.dao;

import com.yang.pojo.Book;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BookMapper {

    //增加一本书
    int addBook(Book book);
    //删除一本书
    int deleteBookById(@Param("bookId") int id);
    //更新一本书
    int updateBook(Book book);
    //查询一本书
    Book queryBookById(@Param("bookId") int id);
    //查询全部书
    List<Book> queryAllBook();
}
