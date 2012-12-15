package com.thoughtworks.assignment.salestax.domain;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Receipt {

    private List<ReceiptDetail> details = new ArrayList<ReceiptDetail>();

    public List<ReceiptDetail> getDetails() {
        return this.details;
    }


    public void addDetail(ReceiptDetail detail) {
        this.details.add(detail);
    }

    /**
     * @return the total tax
     */
    public BigDecimal getTotalTax() {

        BigDecimal totalTax = BigDecimal.valueOf(0.00);

        for (ReceiptDetail detail : details) {
            totalTax = totalTax.add(detail.getTax());
        }

        return totalTax;
    }

    /**
     * @return the total price of the receipt, including tax.
     */
    public BigDecimal getTotalPrice() {

        BigDecimal totalPrice = BigDecimal.valueOf(0.00);

        for (ReceiptDetail detail : details) {
            totalPrice = totalPrice.add(detail.getTotalPrice());
        }

        return totalPrice;
    }

    @Override
    public String toString() {
        StringBuffer buffer = new StringBuffer();

        for (ReceiptDetail detail : details) {
            buffer.append(detail.toString());
            buffer.append(System.getProperty("line.separator"));
        }

        buffer.append("Sales Taxes: ").append(this.getTotalTax().setScale(2).toString());
        buffer.append(System.getProperty("line.separator"));
        buffer.append("Total: ").append(this.getTotalPrice().toString());


        return buffer.toString();
    }
}