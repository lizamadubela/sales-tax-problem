package com.thoughtworks.assignment.salestax.domain;

import junit.framework.Assert;
import org.junit.Test;


public class OrderServiceTest {

    @Test
    public void testGetSetTaxConfigurationRepository() {
        OrderService orderService = new OrderService();

        ITaxConfigurationRepository repository = new ITaxConfigurationRepository() {
            @Override
            public TaxConfiguration findConfiguration(Goods goods) {
                return null;
            }
        };

        orderService.setTaxConfigurationRepository(repository);

        Assert.assertEquals(repository, orderService.getTaxConfigurationRepository());

    }

    @Test
    public void testPurchase() {
        OrderService orderServide = new OrderService();

        Assert.assertNotNull(orderServide.purchase(new Order()));
    }
}
