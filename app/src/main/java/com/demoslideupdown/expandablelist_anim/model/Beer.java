package com.demoslideupdown.expandablelist_anim.model;

import java.util.List;

public class Beer {

    private int id;
    private String name;
          private List<Drink> drink;

    public Beer(int id, String name,List<Drink> drink) {
        this.id = id;
        this.name = name;
        this.drink=drink;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Drink> getDrink () {
        return drink;
    }
}
