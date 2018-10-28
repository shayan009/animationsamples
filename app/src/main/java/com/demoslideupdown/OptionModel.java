package com.demoslideupdown;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OptionModel {

    private int id;
    private String name;

    private OptionModel(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public static List<OptionModel> getOptions() {
        return Arrays.asList(
                new OptionModel(1, "Expandable List") ,
                new OptionModel(2, "Shimmer Effect")
        );
    }
}
