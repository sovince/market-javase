package com.sovince;

import static org.junit.Assert.assertTrue;

import com.sovince.day19pj.dao.CardDao;
import com.sovince.day19pj.dao.GiftDao;
import com.sovince.day19pj.dao.ProductDao;
import com.sovince.day19pj.daoimpl.CardDaoImpl;
import com.sovince.day19pj.daoimpl.GiftDaoImpl;
import com.sovince.day19pj.daoimpl.ProductDaoImpl;
import com.sovince.day19pj.entity.Card;
import com.sovince.day19pj.entity.Gift;
import com.sovince.day19pj.entity.Product;
import com.sovince.day19pj.mapper.ProductMapper;
import com.sovince.day19pj.util.TextMapUtil;
import org.junit.Test;

import java.io.IOException;
import java.util.Map;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }



    @Test
    public void foo4(){
        GiftDao giftDao = new GiftDaoImpl();
        Gift gift = giftDao.findById(1);
        System.out.println(gift);

    }

    @Test
    public void foo3(){
        CardDao cardDao = new CardDaoImpl();
        Card card = cardDao.findById(10);
        System.out.println(card);

        //cardDao.UpdateBalanceById(1,20);
    }

    @Test
    public void foo2(){
        ProductDao productDao = new ProductDaoImpl();
        productDao.updateNumById(2);
    }
    @Test
    public void foo1() throws IOException {
        TextMapUtil<Product> textMapUtil = new TextMapUtil<>("product.txt");
        ProductMapper productMapper = new ProductMapper();

        Map<Integer, Product> map = textMapUtil.readFile(productMapper);

        Product p = new Product(3,"bike",3000,60);
        map.put(3,p);
        map.forEach((k,v)-> System.out.println(k+"---"+v));
        //Map<String, Product> map = textMapper.getMap();

        textMapUtil.writeFileFromMap(productMapper,map);

    }

}
