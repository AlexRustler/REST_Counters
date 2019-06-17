package com.rustler.REST_Counters.model;

public class Counter {
    private String name;
    private Integer count;

    public Counter(String name, Integer count) {
        this.name = name;
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public Integer getCount() {
        return count;
    }
}


