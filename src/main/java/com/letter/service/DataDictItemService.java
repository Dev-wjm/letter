package com.letter.service;

import com.letter.entity.DataDict;
import com.letter.entity.DataDictItem;

import java.util.List;

public interface DataDictItemService {

    List<DataDictItem> findAll();

    List<DataDictItem> findAllByDataDict(String dictId);

    void deleteItem(String id);

    void addItem(DataDictItem item);

}
