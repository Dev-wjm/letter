package com.letter.service.impl;

import com.letter.entity.Notes;
import com.letter.repository.NotesRepository;
import com.letter.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NotesServiceImpl implements NoteService {

    @Autowired
    private NotesRepository notesRepository;

    @Override
    public void addNote(Notes notes) {
        notesRepository.save(notes);
    }

    @Override
    public void delete(String id) {
        notesRepository.deleteById(id);
    }

    @Override
    public Notes show(String id) {
        return notesRepository.findNotesById(id);
    }

    @Override
    public List<Notes> findById(String type, String id) {
        List<Notes> notesList = new ArrayList<>();
        if(null!=type&&"user".equalsIgnoreCase(type)){
            notesList = notesRepository.findNotesByUserId(id);
        }else if (null!=type&&"book".equalsIgnoreCase(type)){
            notesList = notesRepository.findNotesByBookId(id);
        }
        return notesList;
    }

    @Override
    public List<Notes> findAll() {
        return notesRepository.findAll();
    }
}
