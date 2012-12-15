package com.thoughtworks.assignment.salestax.domain;

import junit.framework.Assert;
import org.junit.Test;

public class CategoryTest {

    @Test
    public void testCategory() {
        Assert.assertEquals("book", Category.BOOK.toString());
        Assert.assertEquals("food", Category.FOOD.toString());
        Assert.assertEquals("medical", Category.MEDICAL.toString());
        Assert.assertEquals("music", Category.MUSIC.toString());
    }
}