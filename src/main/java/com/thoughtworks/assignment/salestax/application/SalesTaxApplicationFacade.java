package com.thoughtworks.assignment.salestax.application;

import com.thoughtworks.assignment.salestax.domain.ITaxConfigurationRepository;
import com.thoughtworks.assignment.salestax.domain.Order;
import com.thoughtworks.assignment.salestax.domain.OrderService;
import com.thoughtworks.assignment.salestax.domain.Receipt;
import com.thoughtworks.assignment.salestax.support.TaxConfigurationRepositoryImpl;


public class SalesTaxApplicationFacade {


    private OrderService orderService;

    private static SalesTaxApplicationFacade INSTANCE;

    private SalesTaxApplicationFacade() {}

    public static SalesTaxApplicationFacade getInstance() {
        if (INSTANCE != null) {
            return INSTANCE;
        } else {
            INSTANCE = new SalesTaxApplicationFacade();
            INSTANCE.orderService = new OrderService();

            TaxConfigurationRepositoryImpl repository = new TaxConfigurationRepositoryImpl();
            repository.init();
            INSTANCE.orderService.setTaxConfigurationRepository(repository);

            return INSTANCE;
        }
    }

    public Receipt purchaseOrder(Order order) {
        return this.orderService.purchase(order);
    }
}
