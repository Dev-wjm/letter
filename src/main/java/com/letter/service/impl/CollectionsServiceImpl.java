package com.letter.service.impl;

import com.letter.entity.Collections;
import com.letter.repository.CollectionsRepository;
import com.letter.service.CollectionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.List;

@Service
public class CollectionsServiceImpl implements CollectionsService {

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private CollectionsRepository collectionsRepository;


    @Override
    public List<String> getBooksId(String userId) {
        return collectionsRepository.getBooksId(userId);
    }

    @Override
    public List<String> getUsersId(String bookId) {
        return collectionsRepository.getUsersId(bookId);
    }

    @Override
    public int getCollectionsNum(String sql) {
        if (null!=sql) {
            return entityManager.createQuery(sql).getResultList().size();
        }
        return 0;
    }

    @Override
    public void add(Collections collections) {
        collectionsRepository.save(collections);
    }

    @Override
    public void delete(String id) {
        collectionsRepository.deleteById(id);
    }

    @Override
    public Collections getByUserIdAndBookId(String userId, String bookId) {
        return collectionsRepository.getByUserIdAndBookId(userId,bookId);
    }
}
