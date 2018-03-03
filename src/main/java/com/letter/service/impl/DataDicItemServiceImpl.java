package com.letter.service.impl;

import com.letter.entity.DataDict;
import com.letter.entity.DataDictItem;
import com.letter.repository.DataDictItemRepository;
import com.letter.repository.DataDictRepository;
import com.letter.service.DataDictItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataDicItemServiceImpl implements DataDictItemService {

    @Autowired
    private DataDictItemRepository dataDictItemRepository;

    @Override
    public List<DataDictItem> findAll() {
        return dataDictItemRepository.findAll();
    }

    @Override
    public List<DataDictItem> findAllByDataDict(String dictId) {
        return dataDictItemRepository.findByDictId(dictId);
    }

    @Override
    public void deleteItem(String id) {
        dataDictItemRepository.deleteById(id);
    }

    @Override
    public void addItem(DataDictItem item) {
        dataDictItemRepository.save(item);
    }

}
