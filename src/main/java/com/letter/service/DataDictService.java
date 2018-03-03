package com.letter.service;

import com.letter.entity.DataDict;
import com.letter.entity.DataDictItem;

import java.util.List;

public interface DataDictService {

    List<DataDict> getAll();

    void deleteDataDict(String id);

    void addDataDict(DataDict dataDict);

}
