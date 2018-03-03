package com.letter.controller;

import com.letter.entity.AjaxJsonResult;
import com.letter.entity.Comments;
import com.letter.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping(value = "/comment")
public class CommentsController {

    private static String TYPE_USER = "USER";
    private static String TYPE_BOOK = "BOOK";

    @Autowired
    private CommentService commentService;

    @RequestMapping("/")
    @ResponseBody
    public List<Comments> getAllComment(){
        return commentService.findAll();
    }

    @RequestMapping("/add")
    @ResponseBody
    public AjaxJsonResult addComment(@RequestBody Comments comments){
        AjaxJsonResult result = new AjaxJsonResult();
        comments.setCreated(new Date());
        commentService.addComment(comments);
        result.setSuccess(true);
        result.setMessage("添加成功");
        return result;
    }

    @RequestMapping("/delete/{id}")
    @ResponseBody
    public AjaxJsonResult deleteComment(@PathVariable(value = "id")String id){
        AjaxJsonResult result = new AjaxJsonResult();
        commentService.deleteComent(id);
        result.setSuccess(true);
        result.setMessage("删除成功");
        return result;
    }

    @RequestMapping("/show/{type}/{id}")
    @ResponseBody
    List<Comments> findCommentsByUser(@PathVariable(value = "type") String type, @PathVariable(value = "id")String id){
        List<Comments> list = new ArrayList<>();
        if(null!=type&&TYPE_USER.equalsIgnoreCase(type)){
            list = commentService.findCommentsByUser(id);
        }else if(null!=type && TYPE_BOOK.equalsIgnoreCase(type)){
            list = commentService.findCommentsByBook(id);
        }
        return list;
    }
}
