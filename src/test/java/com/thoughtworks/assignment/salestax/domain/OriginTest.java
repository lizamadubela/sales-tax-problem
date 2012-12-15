package com.thoughtworks.assignment.salestax.domain;

import junit.framework.Assert;
import org.junit.Test;

public class OriginTest {

    @Test
    public void testOrigin() {
        Assert.assertEquals("imported", Origin.imported.toString());
        Assert.assertEquals("domestic", Origin.domestic.toString());
    }

}