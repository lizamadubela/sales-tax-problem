package com.thoughtworks.assignment.salestax.domain;


/**
 * 商品
 */
public class Goods {


    //  INSTANCE PROPERTIES

    private String name;

    private Category category;

    private Origin origin;




    //  GETTERS & SETTERS

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

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


    //operations

}
