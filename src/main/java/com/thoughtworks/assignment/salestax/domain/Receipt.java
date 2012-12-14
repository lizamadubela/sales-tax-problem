package com.thoughtworks.assignment.salestax.domain;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Receipt {

    private List<ReceiptDetail> details = new ArrayList<ReceiptDetail>();

    public List<ReceiptDetail> getDetails() {
        return this.details;
    }

    public BigDecimal getTotalTax() {
        return null;
    }

    /**
     *
     * @return the total price of the receipt, including tax.
     */
    public BigDecimal getTotalPrice() {
        return null;
    }

}