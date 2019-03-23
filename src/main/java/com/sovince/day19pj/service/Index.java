package com.sovince.day19pj.service;

import com.sovince.day19pj.util.Speaker;

import java.util.Scanner;

/**
 * Created by vince
 * Email: so_vince@outlook.com
 * Data: 2019/3/22
 * Time: 20:35
 * Description:
 */
public class Index {
    public void show() {
        Speaker.say("欢迎来到售货机");
        boolean flag = true;
        while (flag){
            Speaker.say("1.购物 2.积分兑换 3.充值 4.退出");
            Scanner scanner = new Scanner(System.in);
            int choose = scanner.nextInt();
            switch (choose) {
                case 1:
                    new Shopping().index();
                    break;
                case 2:
                    new ExchangeGift().index();
                    break;
                case 3:
                    new Recharge().index();
                    break;
                case 4:
                    flag=false;
                    break;
                default:
                    Speaker.say("请输入数字1-4");
            }
        }
        Speaker.say("欢迎再次光临");
    }
}
