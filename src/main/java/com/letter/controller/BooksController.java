package com.letter.controller;

import com.letter.entity.AjaxJsonResult;
import com.letter.entity.Books;
import com.letter.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/books")
public class BooksController {

    @Autowired
    private BookService bookService;

    @RequestMapping("/")
    @ResponseBody
    public List<Books> findAll() {

        return bookService.findAll();
    }

    @RequestMapping("/id/{id}")
    @ResponseBody
    public Books findBooksById(@PathVariable(value = "id") String id) {
        return bookService.findBooksById(id);
    }

    @RequestMapping("/title/{title}")
    @ResponseBody
    public Books findBooksByTitle(@PathVariable(value = "title") String title) {
        return bookService.findBooksByTitle(title);
    }

//    @RequestMapping("/books/{author}")
//    @ResponseBody
//    public Books findBooksByAuthorIs(String author) {
//        return bookService.findBooksByAuthorIs(author);
//    }

    @RequestMapping("/ibsn/{ibsn}")
    @ResponseBody
    public Books findBooksByIbsn(@PathVariable(value = "ibsn") String ibsn) {
        return bookService.findBooksByIbsn(ibsn);
    }

    @RequestMapping("/author/{author}")
    @ResponseBody
    public List<Books> findBooksByAuthor(@PathVariable(value = "author") String author) {
        System.out.println(author);
        return bookService.findBooksByAuthor(author);
    }

    @RequestMapping("/add")
    @ResponseBody
    public AjaxJsonResult addBook(@RequestBody Books book){
        AjaxJsonResult result = new AjaxJsonResult();
        bookService.addBook(book);
        result.setSuccess(true);
        result.setMessage("添加成功");
        return  result;
    }

    @RequestMapping("/delete/{id}")
    @ResponseBody
    public AjaxJsonResult addBook(@PathVariable(value = "id") String id){
        AjaxJsonResult result = new AjaxJsonResult();
        bookService.deleteById(id);
        result.setSuccess(true);
        result.setMessage("删除成功");
        return  result;
    }

    @RequestMapping("/update")
    @ResponseBody
    public AjaxJsonResult updateBook(@RequestBody Books book){
        AjaxJsonResult result = new AjaxJsonResult();
        bookService.updateBook(book);
        result.setSuccess(true);
        result.setMessage("更新成功");
        return  result;
    }
}
