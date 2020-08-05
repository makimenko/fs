package com.makimenko.fs.bff.domain;

public abstract class RefData extends BaseDomain<String> {

    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
