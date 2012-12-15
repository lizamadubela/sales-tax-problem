package com.thoughtworks.assignment.salestax.domain;

public class TaxConfiguration {

    private Category category;

    private Origin origin;

    private ITaxStrategy taxStrategy;

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Origin getOrigin() {
        return origin;
    }

    public void setOrigin(Origin origin) {
        this.origin = origin;
    }

    public ITaxStrategy getTaxStrategy() {
        return taxStrategy;
    }

    public void setTaxStrategy(ITaxStrategy taxStrategy) {
        this.taxStrategy = taxStrategy;
    }
}