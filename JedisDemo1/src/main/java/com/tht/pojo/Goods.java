package com.tht.pojo;

/**
 * @ClassName : com.tht.pojo.Goods
 * @Description : 商品实体类
 * Author : space
 * CreatedDate 2021-04-06 16:33:07
 */
public class Goods {
    private int id;
    private String name;
    private float price;
    private String unit;
    private String type;

    public Goods() {
    }

    public Goods(int id, String name, float price, String unit, String type) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.unit = unit;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }

    public String getUnit() {
        return unit;
    }

    public String getType() {
        return type;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public void setType(String type) {
        this.type = type;
    }
}
