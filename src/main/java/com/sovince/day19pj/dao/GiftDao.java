package com.sovince.day19pj.dao;

import com.sovince.day19pj.entity.Gift;

import java.util.Map;

/**
 * Created by vince
 * Email: so_vince@outlook.com
 * Data: 2019/3/22
 * Time: 13:14
 * Description:
 *
 * private int giftId;
 *     private String name;
 *     private int score;
 */
public interface GiftDao {
    /**
     * 获取全部礼品数据
     * @return
     */
    Map<Integer,Gift> getList();

    /**
     * 获取一个礼品信息
     * @param id
     * @return
     */
    Gift findById(int id);
}
