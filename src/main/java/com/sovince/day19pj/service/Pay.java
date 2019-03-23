package com.sovince.day19pj.service;

import com.sovince.day19pj.dao.CardDao;
import com.sovince.day19pj.dao.ProductDao;
import com.sovince.day19pj.daoimpl.CardDaoImpl;
import com.sovince.day19pj.daoimpl.ProductDaoImpl;
import com.sovince.day19pj.entity.Card;
import com.sovince.day19pj.entity.Product;
import com.sovince.day19pj.util.Speaker;

import java.util.Scanner;

/**
 * Created by vince
 * Email: so_vince@outlook.com
 * Data: 2019/3/22
 * Time: 22:01
 * Description:
 */
public class Pay {
    public void index() {
        Scanner scanner = new Scanner(System.in);
        checkNum();//查询库存 删除购物车中没有库存的
        double total = Cart.countPrice();

        Speaker.say("原价一共" + total + "元");
        Speaker.say("是否使用会员卡? (1是 0否) 按-2返回");
        int choose = scanner.nextInt();

        switch (choose) {
            case -2:
                return;
            case 1:
                //会员支付
                CardDao cardDao = new CardDaoImpl();
                Speaker.say("请输入卡号:");
                Card card = cardDao.findById(scanner.nextInt());

                if (card == null) {
                    Speaker.say("卡号不存在 转为现金支付");
                    payByCash(total);
                } else {
                    int result = payByCard(total, card);
                    if (result == 0) {
                        Speaker.say("余额不足，请返回充值");
                        return;//终止
                    }
                }

                break;
            default:
                payByCash(total);
                break;
        }

        //最后减库存
        reduceNum();
    }

    /**
     * 查看库存
     */
    private void checkNum() {
        ProductDao productDao = new ProductDaoImpl();
        for (Product product : Cart.list) {
//            System.out.println(product);
            int num = productDao.getNumById(product.getProductId());//查询库中数量
            if (num <= 0) {
                //无库存 移出购物车
                Cart.list.remove(product);
                Speaker.alert(product.getName() + " 库存不够了,帮您移出了购物车");
            }
        }
    }

    /**
     * 减少库存
     */
    private void reduceNum() {
        ProductDao productDao = new ProductDaoImpl();
        for (Product product : Cart.list) {
            int result = productDao.updateNumById(product.getProductId());
            if (result == 0) Speaker.alert("没库存但就是不退钱");
        }
        Cart.list.clear();
    }

    /**
     * 现金支付
     *
     * @param total
     */
    private void payByCash(double total) {
        Speaker.alert("现金支付：" + total);
    }

    /**
     * 会员卡支付
     *
     * @param total
     * @param card
     * @return
     */
    private int payByCard(double total, Card card) {
        CardDao cardDao = new CardDaoImpl();
        total = total * card.getDiscount() / 100;//折后价
        double balance = card.getBalance();
        if (balance > total) {
            cardDao.updateBalanceById(card.getCardId(), -total);
            Speaker.alert("卡扣支付：" + total);
            int score = (int) Math.ceil(total / 10);
            cardDao.updateScoreById(card.getCardId(), score);//加积分
            Speaker.alert("积分增加：" + score);
            return 1;
        } else {
            return 0;//余额不足需要充值
        }
    }

}
