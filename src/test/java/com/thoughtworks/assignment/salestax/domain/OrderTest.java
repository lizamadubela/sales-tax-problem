package com.thoughtworks.assignment.salestax.domain;

import junit.framework.Assert;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

public class OrderTest {

    private Order order;
    private OrderItem item1;
    private OrderItem item2;
    private Goods goods1;
    private Goods goods2;

    @Before
    public void setUp() {
        order = new Order();

        goods1 = new Goods();
        goods1.setName("A Book");
        goods1.setCategory(Category.BOOK);
        goods1.setOrigin(Origin.imported);

        item1 = new OrderItem();
        item1.setGoods(goods1);
        item1.setCount(1);
        item1.setUnitPrice(BigDecimal.valueOf(3.83));

        order.addItem(item1);

        goods2 = new Goods();

        goods2.setName("A Music CD");
        goods2.setCategory(Category.MUSIC);
        goods2.setOrigin(Origin.domestic);

        item2 = new OrderItem();
        item2.setGoods(goods2);
        item2.setCount(1);
        item2.setUnitPrice(BigDecimal.valueOf(10.23));

        order.addItem(item2);

    }

    @After
    public void tearDown() {
        order = null;
        item1 = null;
        item2 = null;
        goods1 = null;
        goods2 = null;
    }

    @Test
    public void testOrderItemsCount() {
        Assert.assertEquals(2, order.getItems().size());
    }

    @Test
    public void testAddOrderItem() {
        OrderItem newItem = new OrderItem();
        newItem.setGoods(goods1);
        newItem.setCount(1);
        newItem.setUnitPrice(BigDecimal.valueOf(1.00));
        order.addItem(newItem);

        Assert.assertEquals(3, order.getItems().size());
    }
}
