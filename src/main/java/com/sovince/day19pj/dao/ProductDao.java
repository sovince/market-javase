package com.sovince.day19pj.dao;

import com.sovince.day19pj.entity.Product;

import java.util.Map;

/**
 * Created by vince
 * Email: so_vince@outlook.com
 * Data: 2019/3/22
 * Time: 13:14
 * Description:
 */
public interface ProductDao {
    Map<Integer, Product> getList();

    int updateNumById(int id);

    int getNumById(int id);
}
