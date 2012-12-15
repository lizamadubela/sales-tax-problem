package com.thoughtworks.assignment.salestax.support;

import java.math.BigDecimal;

public class OnlyImportedTax extends RoundTo5CentsStrategy {

    public static final double IMPORT_TAX_RATE = 0.05;

    @Override
    public BigDecimal doCalculateSalesTax(BigDecimal price) {
        return price.multiply(BigDecimal.valueOf(IMPORT_TAX_RATE));
    }
}
