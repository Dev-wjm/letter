package com.letter.service.impl;

import com.letter.entity.Comments;
import com.letter.repository.CommentRepository;
import com.letter.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository;


    @Override
    public List<Comments> findAll() {
        return commentRepository.findAll();
    }

    @Override
    public void addComment(Comments comments) {
        commentRepository.save(comments);
    }

    @Override
    public void deleteComent(String id) {
        commentRepository.deleteById(id);
    }

    @Override
    public Comments findCommentsById(String id) {
        return null;
    }

    @Override
    public List<Comments> findCommentsByBook(String bookId) {
        return commentRepository.findByBookId(bookId);
    }

    @Override
    public List<Comments> findCommentsByUser(String userId) {
        return commentRepository.findByUserId(userId);
    }
}
