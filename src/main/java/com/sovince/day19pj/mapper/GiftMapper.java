package com.sovince.day19pj.mapper;

import com.sovince.day19pj.entity.Gift;


/**
 * Created by vince
 * Email: so_vince@outlook.com
 * Data: 2019/3/22
 * Time: 16:57
 * Description:
 */
public class GiftMapper implements ObjectMapper<Gift>{
    @Override
    public Gift doMap(String[] values) {
        return new Gift(Integer.valueOf(values[0]),values[1],Integer.valueOf(values[2]));
    }

    @Override
    public String unMap(Gift gift) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(gift.getGiftId());
        stringBuilder.append(",");
        stringBuilder.append(gift.getName());
        stringBuilder.append(",");
        stringBuilder.append(gift.getScore());
        return stringBuilder.toString();
    }
}
