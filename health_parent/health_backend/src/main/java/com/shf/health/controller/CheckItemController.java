package com.shf.health.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.shf.health.POJO.CheckItem;
import com.shf.health.entity.PageResult;
import com.shf.health.entity.QueryPageBean;
import com.shf.health.entity.Result;
import com.shf.health.service.CheckItemService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import static com.shf.health.constant.MessageConstant.*;

@RestController
@RequestMapping("/checkitem")
public class CheckItemController {

    @Reference
    private CheckItemService checkItemService;

    @RequestMapping("/add")
    public Result add(@RequestBody CheckItem checkItem){
        System.out.println(checkItem);
        try {
            checkItemService.add(checkItem);
        } catch (Exception e) {
            return new Result(false,ADD_CHECKITEM_FAIL);
        }
        return new Result(true,ADD_CHECKITEM_SUCCESS);
    }

    @RequestMapping("/findPage")
    public PageResult findPage(@RequestBody QueryPageBean queryPageBean){
        System.out.println(queryPageBean);
        return checkItemService.pageQuery(
                queryPageBean.getCurrentPage(),
                queryPageBean.getPageSize(),
                queryPageBean.getQueryString()
        );
    }

    @RequestMapping("delete")
    public Result delete(Integer id){
        try {
            checkItemService.delete(id);
        } catch (Exception e) {
            return new Result(false,DELETE_CHECKITEM_FAIL);
        }
        return new Result(true,DELETE_CHECKITEM_SUCCESS);
    }

    @RequestMapping("findById")
    public Result checkItem(Integer id){
        CheckItem checkItem = null;
        try {
            checkItem = checkItemService.findById(id);
        } catch (Exception e) {
            return new Result(false, QUERY_CHECKITEM_FAIL);
        }
        return new Result(true,QUERY_CHECKITEM_SUCCESS,checkItem);
    }

    @RequestMapping("/edit")
    public Result edit(@RequestBody CheckItem checkItem){
        try {
            checkItemService.edit(checkItem);
        } catch (Exception e) {
            return new Result(false,EDIT_CHECKITEM_FAIL);
        }
        return new Result(true, EDIT_CHECKITEM_SUCCESS);
    }
}
