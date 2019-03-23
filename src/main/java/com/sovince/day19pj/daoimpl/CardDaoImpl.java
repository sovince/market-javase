package com.sovince.day19pj.daoimpl;

import com.sovince.day19pj.dao.CardDao;
import com.sovince.day19pj.entity.Card;
import com.sovince.day19pj.mapper.CardMapper;
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
public class CardDaoImpl implements CardDao {
    private TextMapUtil<Card> textMapUtil;

    public CardDaoImpl() {
        String fileName = "card.txt";
        this.textMapUtil = new TextMapUtil<>(fileName);
    }

    @Override
    public Map<Integer, Card> getList() {
        Map<Integer, Card> cardMap = null;
        try {
            cardMap = textMapUtil.readFile(new CardMapper());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return cardMap;
    }

    @Override
    public Card findById(int id) {
        Map<Integer, Card> list = getList();
        return list.get(id);
    }

    @Override
    public int updateBalanceById(int id, double amount) {
        Map<Integer, Card> list = getList();
        Card card = list.get(id);

        //扣除
        if(amount<0&&card.getBalance()>Math.abs(amount)){
            if(card.getBalance()>Math.abs(amount)){
                card.setBalance(card.getBalance()+amount);
                try {
                    textMapUtil.writeFileFromMap(new CardMapper(),list);
                } catch (IOException e) {
                    e.printStackTrace();
                    return 0;
                }
                return 1;
            }else{
                return 0;
            }
        }

        //充值
        if(amount>0){
            card.setBalance(card.getBalance()+amount);
            try {
                textMapUtil.writeFileFromMap(new CardMapper(),list);
            } catch (IOException e) {
                e.printStackTrace();
                return 0;
            }
            return 1;
        }

        return 0;
    }

    @Override
    public int updateScoreById(int id, int score) {
        Map<Integer, Card> list = getList();
        Card card = list.get(id);

        //扣分
        if(score<0){
            if(card.getScore()>Math.abs(score)){
                card.setScore(card.getScore()+score);
                try {
                    textMapUtil.writeFileFromMap(new CardMapper(),list);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return 1;
            }else{
                return 0;
            }
        }

        //加分
        if(score>0){
            card.setScore(card.getScore()+score);
            card.setScore(card.getScore()+score);
            try {
                textMapUtil.writeFileFromMap(new CardMapper(),list);
            } catch (IOException e) {
                e.printStackTrace();
                return 0;
            }
            return 1;
        }



        return 0;
    }
}
