package com.letter.repository;

import com.letter.entity.Comments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comments,String> {

    List<Comments> findByBookId(String bookId);

    List<Comments> findByUserId(String userId);



}
