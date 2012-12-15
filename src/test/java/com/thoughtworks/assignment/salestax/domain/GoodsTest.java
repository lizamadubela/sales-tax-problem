package com.thoughtworks.assignment.salestax.domain;

import junit.framework.Assert;
import org.junit.Test;

public class GoodsTest {

    @Test
    public void testGoods() {
        Goods goods = new Goods();
        goods.setName("A Book");
        goods.setCategory(Category.book);
        goods.setOrigin(Origin.imported);

        Assert.assertEquals("A Book", goods.getName());
        Assert.assertEquals("book", goods.getCategory().toString());
        Assert.assertEquals("imported", goods.getOrigin().toString());
    }
}
