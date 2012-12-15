package com.thoughtworks.assignment.salestax.domain;

import java.math.BigDecimal;

public class OrderService {

    private ITaxConfigurationRepository taxConfigurationRepository;

    public ITaxConfigurationRepository getTaxConfigurationRepository() {
        return taxConfigurationRepository;
    }

    public void setTaxConfigurationRepository(ITaxConfigurationRepository taxConfigurationRepository) {
        this.taxConfigurationRepository = taxConfigurationRepository;
    }

    public Receipt purchase(Order order) {
        Receipt receipt = new Receipt();

        for (OrderItem item : order.getItems()) {
            TaxConfiguration taxConfiguration = taxConfigurationRepository.findConfiguration(item.getGoods());

            ITaxStrategy strategy = taxConfiguration.getTaxStrategy();
            BigDecimal tax = strategy.calculateSalesTax(item.getSubTotal());

            ReceiptDetail receiptDetail = new ReceiptDetail();
            receiptDetail.setGoods(item.getGoods());
            receiptDetail.setCount(item.getCount());
            receiptDetail.setUnitPrice(item.getUnitPrice());
            receiptDetail.setTax(tax);

            receipt.addDetail(receiptDetail);
        }
        return receipt;
    }
}
