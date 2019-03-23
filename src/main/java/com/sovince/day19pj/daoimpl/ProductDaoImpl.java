package com.sovince.day19pj.daoimpl;

import com.sovince.day19pj.dao.ProductDao;
import com.sovince.day19pj.entity.Product;
import com.sovince.day19pj.mapper.ProductMapper;
import com.sovince.day19pj.util.TextMapUtil;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by vince
 * Email: so_vince@outlook.com
 * Data: 2019/3/22
 * Time: 13:26
 * Description:
 */
public class ProductDaoImpl implements ProductDao {
    private TextMapUtil<Product> textMapUtil;
    public ProductDaoImpl() {
        String fileName = "product.txt";
        this.textMapUtil = new TextMapUtil<>(fileName);
    }

    @Override
    public Map<Integer, Product> getList() {
        Map<Integer, Product> map = new HashMap<>();
        try {
            map = textMapUtil.readFile(new ProductMapper());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return map;
    }


    /**
     * 根据id库存减1
     * @param id
     * @return 1成功 0失败
     */
    @Override
    public int updateNumById(int id) {
        Map<Integer, Product> list = getList();
        Product product = list.get(id);
        if(product.getNum()>0){
            product.setNum(product.getNum()-1);
            try {
                textMapUtil.writeFileFromMap(new ProductMapper(),list);
            } catch (IOException e) {
                e.printStackTrace();
                return 0;
            }
            return 1;
        }else{
            return 0;
        }
    }

    @Override
    public int getNumById(int id) {
        Map<Integer, Product> list = getList();
        Product product = list.get(id);
        return product.getNum();
    }
}
