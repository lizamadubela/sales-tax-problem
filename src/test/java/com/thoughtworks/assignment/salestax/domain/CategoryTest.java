package com.thoughtworks.assignment.salestax.domain;

import junit.framework.Assert;
import org.junit.Test;

public class CategoryTest {

    @Test
    public void testCategory() {
        Assert.assertEquals("book", Category.book.toString());
        Assert.assertEquals("food", Category.food.toString());
        Assert.assertEquals("medical", Category.medical.toString());
        Assert.assertEquals("music", Category.music.toString());
    }
}