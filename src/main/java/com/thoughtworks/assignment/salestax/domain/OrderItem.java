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

    @Override
    public String toString() {
        StringBuffer buffer = new StringBuffer();

        buffer.append(count);
        buffer.append(" ");

        if (goods.getOrigin() == Origin.imported) {
            buffer.append("imported ");
        }

        buffer.append(goods.getName());
        buffer.append(" ");

        buffer.append("at ");
        buffer.append(unitPrice.setScale(2).toString());

        return buffer.toString();
    }
}
