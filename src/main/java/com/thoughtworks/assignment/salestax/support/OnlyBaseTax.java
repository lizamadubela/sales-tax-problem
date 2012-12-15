package com.thoughtworks.assignment.salestax.support;

import java.math.BigDecimal;

public class OnlyBaseTax extends RoundTo5CentsStrategy {

    public static final double BASE_TAX_RATE = 0.10;

    @Override
    public BigDecimal doCalculateSalesTax(BigDecimal price) {
        return price.multiply(BigDecimal.valueOf(BASE_TAX_RATE));
    }
}
