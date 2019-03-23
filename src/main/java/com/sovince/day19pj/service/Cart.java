package com.sovince.day19pj.service;

import com.sovince.day19pj.entity.Product;
import com.sovince.day19pj.util.Speaker;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vince
 * Email: so_vince@outlook.com
 * Data: 2019/3/22
 * Time: 21:28
 * Description:购物车
 *
 */
public class Cart {
    public static final List<Product> list= new ArrayList<>();//货单集合

    public static void show(){
        Speaker.say("购物车列表");
        for(Product product:list){
            Speaker.alert(product.getProductId()+"  "+product.getName()+"  "+product.getPrice()+"元"+"*1");
        }
    }

    public static int countPrice(){
        int price=0;
        for(Product product:list){
            price+=product.getPrice();
        }
        return price;
    }


}
