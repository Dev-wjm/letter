package com.letter.repository;

import com.letter.entity.DataDict;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DataDictRepository extends JpaRepository<DataDict,String> {

}
