package com.sovince.day19pj.service;

import com.sovince.day19pj.dao.CardDao;
import com.sovince.day19pj.daoimpl.CardDaoImpl;
import com.sovince.day19pj.entity.Card;
import com.sovince.day19pj.util.Speaker;

import java.util.Scanner;

/**
 * Created by vince
 * Email: so_vince@outlook.com
 * Data: 2019/3/23
 * Time: 14:43
 * Description:
 */
public class Recharge {

    public void index(){
        Scanner scanner = new Scanner(System.in);
        CardDao cardDao = new CardDaoImpl();

        Speaker.say("请输入卡号");
        int cardId = scanner.nextInt();
        Card card = cardDao.findById(cardId);
        if (card != null){
            Speaker.alert("当前余额："+card.getBalance());
            Speaker.say("请输入充值金额");
            int amount = scanner.nextInt();
            int result = cardDao.updateBalanceById(cardId, amount);
            cardDao.updateScoreById(cardId,amount);
            if(result==1){
                Speaker.alert("充值成功");
            }else {
                Speaker.alert("充值失败");
            }
            card = cardDao.findById(cardId);
            Speaker.alert("当前余额："+card.getBalance());
            Speaker.alert("当前积分："+card.getScore());
        }else {
            Speaker.alert("卡号不存在");
        }
    }
}
