package com.letter.controller;

import com.letter.entity.AjaxJsonResult;
import com.letter.entity.Notes;
import com.letter.service.NoteService;
import com.letter.utils.IDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/note")
public class NoteController {

    @Autowired
    private NoteService noteService;

    @RequestMapping("/")
    @ResponseBody
    public List<Notes> findAll() {
        return noteService.findAll();
    }

    @RequestMapping("/add")
    @ResponseBody
    public AjaxJsonResult addNote(@RequestBody Notes notes) {
        AjaxJsonResult result = new AjaxJsonResult();
        notes.setId(IDUtil.getId());
        notes.setCreate(new Date());
        notes.setUpdate(new Date());
        noteService.addNote(notes);
        result.setSuccess(true);
        result.setMessage("添加成功");
        return result;
    }

    @RequestMapping("/update")
    @ResponseBody
    public AjaxJsonResult updateNote(@RequestBody Notes notes) {
        AjaxJsonResult result = new AjaxJsonResult();
        notes.setUpdate(new Date());
        noteService.addNote(notes);
        result.setSuccess(true);
        result.setMessage("更新成功");
        return result;
    }

    @RequestMapping("/delete/{id}")
    @ResponseBody
    public AjaxJsonResult deleteNote(@PathVariable(value = "id") String id) {
        AjaxJsonResult result = new AjaxJsonResult();
        noteService.delete(id);
        result.setSuccess(true);
        result.setMessage("删除成功");
        return result;
    }

    @RequestMapping("/show/{id}")
    @ResponseBody
    public Notes getNote(@PathVariable(value = "id") String id) {
        Notes notes = noteService.show(id);
        return notes;
    }

    @RequestMapping("/{type}/{id}")
    @ResponseBody
    public List<Notes> getNoteList(@PathVariable(value = "type") String type, @PathVariable(value = "id") String id) {
        List<Notes> notesList = noteService.findById(type,id);
        return notesList;
    }



}
