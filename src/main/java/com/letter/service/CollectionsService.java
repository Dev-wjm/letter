package com.letter.service;

import com.letter.entity.Collections;

import java.util.List;

public interface CollectionsService {

    List<String> getBooksId(String userId);

    List<String> getUsersId(String bookId);

    int getCollectionsNum(String sql);

    void add(Collections collections);

    void delete(String id);

    Collections getByUserIdAndBookId(String userId,String bookId);
}
