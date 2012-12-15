package com.thoughtworks.assignment.salestax.support;

import com.thoughtworks.assignment.salestax.domain.ITaxStrategy;

import java.math.BigDecimal;

public abstract class RoundTo5CentsStrategy implements ITaxStrategy {

    @Override
    public final BigDecimal calculateSalesTax(BigDecimal price) {
        BigDecimal raw = doCalculateSalesTax(price);
        raw = raw.multiply(BigDecimal.valueOf(20.00));
        raw = BigDecimal.valueOf(Math.ceil(raw.doubleValue()) / 20.00);
        return raw;
    }

    public abstract BigDecimal doCalculateSalesTax(BigDecimal price);
}