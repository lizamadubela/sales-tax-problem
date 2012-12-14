package com.thoughtworks.assignment.salestax.domain;


import java.util.ArrayList;
import java.util.List;

/**
 * 订单
 */
public class Order {

    private List<OrderItem> items = new ArrayList<OrderItem>();

    public List<OrderItem> getItems() {
        return this.items;
    }

    public void addItem(OrderItem item) {
        items.add(item);
    }

    public Receipt purchase() {
        return null;
    }

}