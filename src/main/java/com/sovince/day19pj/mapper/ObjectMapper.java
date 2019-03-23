package com.sovince.day19pj.mapper;


/**
 * Created by vince
 * Email: so_vince@outlook.com
 * Data: 2019/3/22
 * Time: 16:54
 * Description:
 */
public interface ObjectMapper<T> {
    T doMap(String[] values);

    String unMap(T t);
}
