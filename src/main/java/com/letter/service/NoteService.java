package com.letter.service;

import com.letter.entity.Notes;

import java.util.List;

public interface NoteService {
    void addNote(Notes notes);
    void delete(String id);
    Notes show(String id);

    /**
     * 通过书籍ID 或者 用户 ID 获取笔记
     * @param type
     * @param id
     * @return
     */
    List<Notes> findById(String type,String id);

    List<Notes> findAll();
}
