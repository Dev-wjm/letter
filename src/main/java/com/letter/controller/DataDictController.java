package com.letter.controller;

import com.letter.entity.AjaxJsonResult;
import com.letter.entity.DataDictItem;
import com.letter.service.DataDictItemService;
import com.letter.utils.IDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/dictItem")
public class DataDictController {

    @Autowired
    private DataDictItemService dataDictItemService;

    @RequestMapping(value = "/",method = RequestMethod.GET)
    @ResponseBody
    public List<DataDictItem> getAll(){
        return dataDictItemService.findAll();
    }

    @RequestMapping(value = "/",method = RequestMethod.POST)
    @ResponseBody
    public AjaxJsonResult add(@RequestBody DataDictItem item){
        AjaxJsonResult result = new AjaxJsonResult();
        item.setId(IDUtil.getId());
        dataDictItemService.addItem(item);
        result.setSuccess(true);
        result.setMessage("添加成功");
        return null;
    }

    @RequestMapping(value = "/{dictCode}",method = RequestMethod.GET)
    @ResponseBody
    public List<DataDictItem> getItemList(@PathVariable(value = "dictCode") String dictCode){
        return dataDictItemService.findAllByDataDict(dictCode);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public AjaxJsonResult add(@PathVariable(value = "id") String id){
        AjaxJsonResult result = new AjaxJsonResult();
        dataDictItemService.deleteItem(id);
        result.setSuccess(true);
        result.setMessage("删除成功");
        return null;
    }

    @RequestMapping(value = "/",method = RequestMethod.PUT)
    @ResponseBody
    public AjaxJsonResult update(@RequestBody DataDictItem item){
        AjaxJsonResult result = new AjaxJsonResult();
        dataDictItemService.addItem(item);
        result.setSuccess(true);
        result.setMessage("更新成功");
        return null;
    }

}
