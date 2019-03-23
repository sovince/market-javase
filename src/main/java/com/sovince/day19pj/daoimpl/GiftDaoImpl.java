package com.sovince.day19pj.daoimpl;

import com.sovince.day19pj.dao.GiftDao;
import com.sovince.day19pj.entity.Gift;
import com.sovince.day19pj.mapper.GiftMapper;
import com.sovince.day19pj.util.TextMapUtil;

import java.io.IOException;
import java.util.Map;

/**
 * Created by vince
 * Email: so_vince@outlook.com
 * Data: 2019/3/22
 * Time: 13:23
 * Description:
 */
public class GiftDaoImpl implements GiftDao {

    private TextMapUtil<Gift> textMapUtil;

    public GiftDaoImpl() {
        String fileName = "gift.txt";
        this.textMapUtil = new TextMapUtil<>(fileName);
    }

    @Override
    public Map<Integer, Gift> getList() {
        Map<Integer, Gift> giftMap = null;
        try {
            giftMap = textMapUtil.readFile(new GiftMapper());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return giftMap;
    }

    @Override
    public Gift findById(int id) {
        Map<Integer, Gift> list = getList();
        return list.get(id);
    }
}
