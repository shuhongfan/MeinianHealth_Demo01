package com.shf.health.service;

import com.github.pagehelper.Page;
import com.shf.health.POJO.CheckItem;
import com.shf.health.entity.PageResult;

public interface CheckItemService {
    public void add(CheckItem checkItem);

    public PageResult pageQuery(Integer currentPage, Integer pageSize, String queryString);

    public void delete(Integer id);

    public CheckItem findById(Integer id);

    public void edit(CheckItem checkItem);
}
