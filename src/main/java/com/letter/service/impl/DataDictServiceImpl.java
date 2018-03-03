package com.letter.service.impl;

import com.letter.entity.DataDict;
import com.letter.entity.DataDictItem;
import com.letter.repository.DataDictItemRepository;
import com.letter.repository.DataDictRepository;
import com.letter.service.DataDictItemService;
import com.letter.service.DataDictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataDictServiceImpl implements DataDictService {

    @Autowired
    private DataDictRepository dataDictRepository;

    @Override
    public List<DataDict> getAll() {
        return dataDictRepository.findAll();
    }

    @Override
    public void deleteDataDict(String id) {
        dataDictRepository.deleteById(id);
    }

    @Override
    public void addDataDict(DataDict dataDict) {
        dataDictRepository.save(dataDict);
    }


}
