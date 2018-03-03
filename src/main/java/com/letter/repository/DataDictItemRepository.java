package com.letter.repository;

import com.letter.entity.DataDictItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DataDictItemRepository extends JpaRepository<DataDictItem,String> {

    List<DataDictItem> findByDictId(@Param(value = "dictId") String dictId);
}
