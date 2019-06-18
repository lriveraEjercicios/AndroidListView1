package com.example.listview1.model;

public class Product {
    String name;
    int units;
    boolean is_bought;

    public Product(String name) {
        this.name = name;
        this.units=1;
        is_bought=false;
    }

    public Product(String name, int units, boolean is_bought) {
        this.name = name;
        this.units = units;
        this.is_bought = is_bought;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getUnits() {
        return units;
    }

    public void setUnits(int units) {
        this.units = units;
    }

    public boolean isIs_bought() {
        return is_bought;
    }

    public void setIs_bought(boolean is_bought) {
        this.is_bought = is_bought;
    }
}
