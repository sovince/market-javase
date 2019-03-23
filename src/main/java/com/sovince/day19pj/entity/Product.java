package com.sovince.day19pj.entity;

/**
 * Created by vince
 * Email: so_vince@outlook.com
 * Data: 2019/3/22
 * Time: 13:04
 * Description:产品：产品编号、名称、价格、剩余量
 */
public class Product {
    private int productId;
    private String name;
    private int price;
    private int num;

    public Product() {
    }

    public Product(int productId, String name, int price, int num) {
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.num = num;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", num=" + num +
                '}';
    }
}
