package com.sovince.day19pj.service;

import com.sovince.day19pj.dao.ProductDao;
import com.sovince.day19pj.daoimpl.ProductDaoImpl;
import com.sovince.day19pj.entity.Product;
import com.sovince.day19pj.util.Speaker;

import java.util.Map;
import java.util.Scanner;

/**
 * Created by vince
 * Email: so_vince@outlook.com
 * Data: 2019/3/22
 * Time: 20:47
 * Description:
 */
public class Shopping {


    public void index() {
        ProductDao productDao = new ProductDaoImpl();
        Map<Integer, Product> list = productDao.getList();

        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        while (flag) {
            Speaker.say("商品列表");
            for (Product product : list.values()) {
                Speaker.alert(product.getProductId() + "  " + product.getName() + "  " + product.getPrice() + "元");
            }
            Speaker.say("请挑选商品 按0结账 按-1显示购物车列表 按-2返回");
            int choose = scanner.nextInt();

            switch (choose) {
                case -2:
                    flag=false;
                    break;
                case -1:
                    //查看已选
                    Cart.show();
                    break;
                case 0:
                    new Pay().index();
                    break;
                default:
                    //选
                    if (list.containsKey(choose)) {
                        Cart.list.add(list.get(choose));//把商品加入购物车
                        Speaker.alert("加入购物车成功！");
                    } else {
                        Speaker.alert("没有这件商品");
                    }
                    break;
            }

        }
    }
}
