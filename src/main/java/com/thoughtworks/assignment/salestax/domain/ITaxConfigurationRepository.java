package com.thoughtworks.assignment.salestax.domain;


public interface ITaxConfigurationRepository {
    public TaxConfiguration findConfiguration(Goods goods);
}