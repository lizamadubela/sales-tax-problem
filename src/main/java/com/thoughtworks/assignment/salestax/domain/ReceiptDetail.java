package com.thoughtworks.assignment.salestax.domain;


import java.math.BigDecimal;

public class ReceiptDetail {

    // property

    private Goods goods;

    private Integer count;

    private BigDecimal unitPrice;

    private BigDecimal tax;

    // getters && setters

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

    public BigDecimal getTax() {
        return tax;
    }

    public void setTax(BigDecimal tax) {
        this.tax = tax;
    }


    public BigDecimal getTotalPrice() {
        return unitPrice.add(tax);
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
        buffer.append(": ");
        buffer.append(getTotalPrice().setScale(2));

        return buffer.toString();
    }
}
