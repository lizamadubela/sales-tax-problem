package com.thoughtworks.assignment.salestax.support;

import com.thoughtworks.assignment.salestax.domain.ITaxStrategy;

import java.math.BigDecimal;

public class NoTax implements ITaxStrategy {
    @Override
    public BigDecimal calculateSalesTax(BigDecimal price) {
        return BigDecimal.ZERO;
    }
}
