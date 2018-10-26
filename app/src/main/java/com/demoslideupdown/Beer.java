package com.demoslideupdown;

public class Beer {

    private int id;
    private String name;
    private boolean isChecked;

    public Beer(int id, String name, boolean isChecked) {
        this.id = id;
        this.name = name;
        this.isChecked = isChecked;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public boolean isChecked() {
        return isChecked;
    }
}
