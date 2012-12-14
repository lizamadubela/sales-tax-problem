package com.thoughtworks.assignment.salestax.domain;


import java.math.BigDecimal;

/**
 * 订单项
 */
public class OrderItem {

    // property

    private Goods goods;

    private Integer count;

    private BigDecimal unitPrice;


    // getters & setters

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }
}
