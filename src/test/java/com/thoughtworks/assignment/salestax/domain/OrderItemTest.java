package com.thoughtworks.assignment.salestax.domain;

import junit.framework.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class OrderItemTest {

    @Test
    public void testOrderItem() {
        OrderItem item = new OrderItem();

        Goods goods = new Goods();
        goods.setName("A Book");
        goods.setCategory(Category.book);
        goods.setOrigin(Origin.imported);

        item.setGoods(goods);
        item.setCount(2);
        item.setUnitPrice(BigDecimal.valueOf(2.85));

        Assert.assertEquals(goods, item.getGoods());
        Assert.assertEquals(Integer.valueOf(2), item.getCount());
        Assert.assertEquals("2.85", item.getUnitPrice().toString());
    }
}
