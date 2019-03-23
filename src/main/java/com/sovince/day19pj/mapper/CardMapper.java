package com.sovince.day19pj.mapper;

import com.sovince.day19pj.entity.Card;


/**
 * Created by vince
 * Email: so_vince@outlook.com
 * Data: 2019/3/22
 * Time: 16:58
 * Description:
 */
public class CardMapper implements ObjectMapper<Card>{
    @Override
    public Card doMap(String[] values) {
        return new Card(
                Integer.valueOf(values[0]),
                Double.valueOf(values[1]),
                Integer.valueOf(values[2]),
                Double.valueOf(values[3])
        );
    }

    @Override
    public String unMap(Card card) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(card.getCardId());
        stringBuilder.append(",");
        stringBuilder.append(card.getBalance());
        stringBuilder.append(",");
        stringBuilder.append(card.getScore());
        stringBuilder.append(",");
        stringBuilder.append(card.getDiscount());
        return stringBuilder.toString();
    }
}
