package com.thoughtworks.assignment.salestax.domain;

import java.math.BigDecimal;

/**
 * 销售税计算策略
 */
public interface ITaxStrategy {

    /**
     * 根据商品价格计算销售税值
     * @param price 税前价格
     * @return 销售税
     */
    public BigDecimal calculateSalesTax(BigDecimal price);
}