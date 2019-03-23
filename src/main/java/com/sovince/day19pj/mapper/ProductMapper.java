package com.sovince.day19pj.mapper;

import com.sovince.day19pj.entity.Product;


/**
 * Created by vince
 * Email: so_vince@outlook.com
 * Data: 2019/3/22
 * Time: 16:57
 * Description:
 */
public class ProductMapper implements ObjectMapper<Product>{
    @Override
    public Product doMap(String[] values) {

        return new Product(
                Integer.valueOf(values[0]),
                values[1],
                Integer.valueOf(values[2]),
                Integer.valueOf(values[3])
        );
    }

    @Override
    public String unMap(Product product) {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(product.getProductId());
        stringBuilder.append(",");
        stringBuilder.append(product.getName());
        stringBuilder.append(",");
        stringBuilder.append(product.getPrice());
        stringBuilder.append(",");
        stringBuilder.append(product.getNum());

        return stringBuilder.toString();
    }
}
