package com.thoughtworks.assignment.salestax.domain;

public class Category {

    public static final Category FOOD       = new Category("food");

    public static final Category BOOK       = new Category("book");

    public static final Category MEDICAL    = new Category("medical");

    public static final Category MUSIC      = new Category("music");

    public static final Category COSMETICS  = new Category("cosmetics");


    private String name;

    public Category(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}