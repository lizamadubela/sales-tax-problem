package com.thoughtworks.assignment.salestax.support;

import com.thoughtworks.assignment.salestax.domain.ITaxStrategy;

import java.math.BigDecimal;

public class DoubleTax implements ITaxStrategy {

    private ITaxStrategy baseTaxStrategy = new OnlyBaseTax();
    private ITaxStrategy importTaxStrategy = new OnlyImportedTax();

    @Override
    public BigDecimal calculateSalesTax(BigDecimal price) {
        return baseTaxStrategy.calculateSalesTax(price).add(importTaxStrategy.calculateSalesTax(price));
    }
}
