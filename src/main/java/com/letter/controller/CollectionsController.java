package com.letter.controller;

import com.letter.entity.AjaxJsonResult;
import com.letter.entity.Collections;
import com.letter.service.CollectionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.UUID;

@Controller
@RequestMapping("/collection")
public class CollectionsController {

    @Autowired
    private CollectionsService collectionsService;

    @RequestMapping("/add")
    @ResponseBody
    public AjaxJsonResult add(@RequestBody Collections collections) {
        AjaxJsonResult result = new AjaxJsonResult();
        collections.setId(UUID.randomUUID().toString().replace("-",""));
        collectionsService.add(collections);
        result.setSuccess(true);
        result.setMessage("收藏成功");
        return result;
    }

    @RequestMapping("/delete/{id}")
    @ResponseBody
    public AjaxJsonResult delete(@PathVariable(value = "id") String id) {
        AjaxJsonResult result = new AjaxJsonResult();
        collectionsService.delete(id);
        result.setSuccess(true);
        result.setMessage("取消收藏");
        return result;
    }

//    @RequestMapping("/{type}/{id}")
//    @ResponseBody
//    public AjaxJsonResult getSize(@PathVariable(value = "id") String type, @PathVariable(value = "id") String id) {
//        AjaxJsonResult result = new AjaxJsonResult();
//        collectionsService.delete(id);
//        result.setSuccess(true);
//        result.setMessage("取消收藏");
//        return null;
//    }

    @RequestMapping("/show")
    @ResponseBody
    public Collections getCollection(String userId, String bookId) {
        Collections collection = collectionsService.getByUserIdAndBookId(userId,bookId);
        return collection;
    }
}
