package com.shf.health.dao;

import com.github.pagehelper.Page;
import com.shf.health.POJO.CheckItem;

public interface CheckItemDao {
    public void add(CheckItem checkItem);

    public Page<CheckItem> selectByCondition(String queryString);

    public long findCountByCheckItemId(Integer checkItemId);

    public void deleteById(Integer id);

    public CheckItem findById(Integer id);

    public void edit(CheckItem checkItem);
}
