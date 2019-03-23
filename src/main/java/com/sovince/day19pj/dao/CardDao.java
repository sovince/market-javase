package com.sovince.day19pj.dao;

import com.sovince.day19pj.entity.Card;

import java.util.Map;

/**
 * Created by vince
 * Email: so_vince@outlook.com
 * Data: 2019/3/22
 * Time: 13:14
 * Description:
 */
public interface CardDao {
    /**
     * 获取全部数据
     * @return map
     */
    Map<Integer,Card> getList();

    /**
     * 根据id 获取一个
     * @param id
     * @return card
     */
    Card findById(int id);

    /**
     * 根据id更新余额
     * @param id
     * @param amount 正负数额
     * @return 0失败 1成功
     */
    int updateBalanceById(int id, double amount);

    int updateScoreById(int id, int score);

}
