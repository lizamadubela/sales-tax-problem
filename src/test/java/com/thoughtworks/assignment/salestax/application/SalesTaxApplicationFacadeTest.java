package com.thoughtworks.assignment.salestax.application;

import com.thoughtworks.assignment.salestax.domain.Category;
import com.thoughtworks.assignment.salestax.domain.Goods;
import com.thoughtworks.assignment.salestax.domain.Order;
import com.thoughtworks.assignment.salestax.domain.OrderItem;
import com.thoughtworks.assignment.salestax.domain.Origin;
import com.thoughtworks.assignment.salestax.domain.Receipt;
import com.thoughtworks.assignment.salestax.domain.ReceiptDetail;
import junit.framework.Assert;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.math.BigDecimal;

public class SalesTaxApplicationFacadeTest {

    public static SalesTaxApplicationFacade facade;

    @BeforeClass
    public static void setUp() {
        facade = SalesTaxApplicationFacade.getInstance();
    }

    @AfterClass
    public static void tearDown() {
        facade = null;
    }

    @Test
    public void testInput1() {
        System.out.println("*********************************************************");
        Goods goods1 = new Goods();
        goods1.setName("book");
        goods1.setCategory(Category.BOOK);
        goods1.setOrigin(Origin.domestic);
        OrderItem item1 = new OrderItem();
        item1.setGoods(goods1);
        item1.setCount(1);
        item1.setUnitPrice(BigDecimal.valueOf(12.49));

        Goods goods2 = new Goods();
        goods2.setName("music CD");
        goods2.setCategory(Category.MUSIC);
        goods2.setOrigin(Origin.domestic);
        OrderItem item2 = new OrderItem();
        item2.setGoods(goods2);
        item2.setCount(1);
        item2.setUnitPrice(BigDecimal.valueOf(14.99));

        Goods goods3 = new Goods();
        goods3.setName("chocolate bar");
        goods3.setCategory(Category.FOOD);
        goods3.setOrigin(Origin.domestic);
        OrderItem item3 = new OrderItem();
        item3.setGoods(goods3);
        item3.setCount(1);
        item3.setUnitPrice(BigDecimal.valueOf(0.85));


        Order order = new Order();

        order.addItem(item1);
        order.addItem(item2);
        order.addItem(item3);

        System.out.println("Input 1:");
        System.out.print(order);
        Receipt receipt = facade.purchaseOrder(order);
        System.out.println("Output 1:");
        System.out.println(receipt);

        ReceiptDetail detail1 = receipt.getDetails().get(0);
        ReceiptDetail detail2 = receipt.getDetails().get(1);
        ReceiptDetail detail3 = receipt.getDetails().get(2);

        Assert.assertEquals(12.49, detail1.getTotalPrice().doubleValue());
        Assert.assertEquals(16.49, detail2.getTotalPrice().doubleValue());
        Assert.assertEquals(0.85, detail3.getTotalPrice().doubleValue());

        Assert.assertEquals(1.50, receipt.getTotalTax().doubleValue());
        Assert.assertEquals(29.83, receipt.getTotalPrice().doubleValue());

        System.out.println("*********************************************************");
    }

    @Test
    public void testInput2() {
        System.out.println("*********************************************************");

        Goods goods1 = new Goods();
        goods1.setName("box of chocolates");
        goods1.setCategory(Category.FOOD);
        goods1.setOrigin(Origin.imported);
        OrderItem item1 = new OrderItem();
        item1.setGoods(goods1);
        item1.setCount(1);
        item1.setUnitPrice(BigDecimal.valueOf(10.00));

        Goods goods2 = new Goods();
        goods2.setName("bottle of perfume");
        goods2.setCategory(Category.COSMETICS);
        goods2.setOrigin(Origin.imported);
        OrderItem item2 = new OrderItem();
        item2.setGoods(goods2);
        item2.setCount(1);
        item2.setUnitPrice(BigDecimal.valueOf(47.50));


        Order order = new Order();

        order.addItem(item1);
        order.addItem(item2);

        System.out.println("Input 2:");
        System.out.print(order);
        Receipt receipt = facade.purchaseOrder(order);
        System.out.println("Output 2:");
        System.out.println(receipt);


        ReceiptDetail detail1 = receipt.getDetails().get(0);
        ReceiptDetail detail2 = receipt.getDetails().get(1);

        Assert.assertEquals(10.50, detail1.getTotalPrice().doubleValue());
        Assert.assertEquals(54.65, detail2.getTotalPrice().doubleValue());
        Assert.assertEquals(7.65, receipt.getTotalTax().doubleValue());
        Assert.assertEquals(65.15, receipt.getTotalPrice().doubleValue());

        System.out.println("*********************************************************");
    }

    @Test
    public void testInput3() {
        System.out.println("*********************************************************");

        Goods goods1 = new Goods();
        goods1.setName("bottle of perfume");
        goods1.setCategory(Category.COSMETICS);
        goods1.setOrigin(Origin.imported);
        OrderItem item1 = new OrderItem();
        item1.setGoods(goods1);
        item1.setCount(1);
        item1.setUnitPrice(BigDecimal.valueOf(27.99));

        Goods goods2 = new Goods();
        goods2.setName("bottle of perfum");
        goods2.setCategory(Category.COSMETICS);
        goods2.setOrigin(Origin.domestic);
        OrderItem item2 = new OrderItem();
        item2.setGoods(goods2);
        item2.setCount(1);
        item2.setUnitPrice(BigDecimal.valueOf(18.99));

        Goods goods3 = new Goods();
        goods3.setName("packet of headache pills");
        goods3.setCategory(Category.MEDICAL);
        goods3.setOrigin(Origin.domestic);
        OrderItem item3 = new OrderItem();
        item3.setGoods(goods3);
        item3.setCount(1);
        item3.setUnitPrice(BigDecimal.valueOf(9.75));

        Goods goods4 = new Goods();
        goods4.setName("box of chocolates");
        goods4.setCategory(Category.FOOD);
        goods4.setOrigin(Origin.imported);
        OrderItem item4 = new OrderItem();
        item4.setGoods(goods4);
        item4.setCount(1);
        item4.setUnitPrice(BigDecimal.valueOf(11.25));


        Order order = new Order();

        order.addItem(item1);
        order.addItem(item2);
        order.addItem(item3);
        order.addItem(item4);

        System.out.println("Input 3:");
        System.out.print(order);
        Receipt receipt = facade.purchaseOrder(order);
        System.out.println("Output 3:");
        System.out.println(receipt);


        ReceiptDetail detail1 = receipt.getDetails().get(0);
        ReceiptDetail detail2 = receipt.getDetails().get(1);
        ReceiptDetail detail3 = receipt.getDetails().get(2);
        ReceiptDetail detail4 = receipt.getDetails().get(3);

        Assert.assertEquals(32.19, detail1.getTotalPrice().doubleValue());
        Assert.assertEquals(20.89, detail2.getTotalPrice().doubleValue());
        Assert.assertEquals(9.75, detail3.getTotalPrice().doubleValue());
        Assert.assertEquals(11.85, detail4.getTotalPrice().doubleValue());

        Assert.assertEquals(6.70, receipt.getTotalTax().doubleValue());
        Assert.assertEquals(74.68, receipt.getTotalPrice().doubleValue());

        System.out.println("*********************************************************");

    }
}
