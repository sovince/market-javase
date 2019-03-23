package com.sovince.day19pj.service;

import com.sovince.day19pj.dao.CardDao;
import com.sovince.day19pj.dao.GiftDao;
import com.sovince.day19pj.daoimpl.CardDaoImpl;
import com.sovince.day19pj.daoimpl.GiftDaoImpl;
import com.sovince.day19pj.entity.Card;
import com.sovince.day19pj.entity.Gift;
import com.sovince.day19pj.util.Speaker;

import java.util.Map;
import java.util.Scanner;

/**
 * Created by vince
 * Email: so_vince@outlook.com
 * Data: 2019/3/23
 * Time: 11:54
 * Description:
 */
public class ExchangeGift {
    public void index() {
        Scanner scanner = new Scanner(System.in);

        GiftDao giftDao = new GiftDaoImpl();
        CardDao cardDao = new CardDaoImpl();
        Map<Integer, Gift> list = giftDao.getList();

        Speaker.say("请输入卡号");
        int cardId = scanner.nextInt();
        Card card = cardDao.findById(cardId);

        if (card != null) {
            boolean flag = true;
            while (flag) {
                Speaker.alert("当前积分：" + card.getScore());
                Speaker.say("礼品列表");
                for (Gift gift : list.values()) {
                    Speaker.alert(gift.getGiftId() + " " + gift.getName() + " " + gift.getScore());
                }
                Speaker.say("请挑选礼品 按 -2 返回");
                int choose = scanner.nextInt();
                if (choose == -2) {
                    flag = false;//返回上一层
                } else {
                    Gift gift = giftDao.findById(choose);
                    if (gift == null) {
                        Speaker.alert("没有该礼品");
                    } else {
                        //兑换礼品
                        if (gift.getScore() > card.getScore()) {
                            Speaker.alert("积分不足");
                        } else {

                            card.setScore(card.getScore()-gift.getScore());
                            cardDao.updateScoreById(cardId, -(gift.getScore()));
                            Speaker.alert("恭喜你兑换了"+gift.getName()+"*1");

                        }
                    }
                }
            }
        } else {
            Speaker.alert("卡号不存在");
        }


    }


}
