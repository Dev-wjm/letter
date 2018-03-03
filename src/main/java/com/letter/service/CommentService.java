package com.letter.service;

import com.letter.entity.Comments;

import java.util.List;

public interface CommentService {

    List<Comments> findAll();

    void addComment(Comments comments);

    void deleteComent(String id);

    Comments findCommentsById(String id);

    List<Comments> findCommentsByBook(String bookId);

    List<Comments> findCommentsByUser(String userId);

}
