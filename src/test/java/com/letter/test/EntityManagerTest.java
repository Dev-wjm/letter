package com.letter.test;

import com.letter.entity.Books;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:applicationContext.xml"})
public class EntityManagerTest {
    @Autowired
    private EntityManager entityManager;

    @Test
    public void test01() {
//        String sql = "select b from Books b where b.id=:id";
//        Query query = entityManager.createQuery(sql);
//        query.setParameter("id","27179305");
//
//        List<Books> books = query.getResultList();
//        System.out.println(books.size());

    }
}
