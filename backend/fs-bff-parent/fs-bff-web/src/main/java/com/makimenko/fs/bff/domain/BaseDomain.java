package com.makimenko.fs.bff.domain;

import java.io.Serializable;

public abstract class BaseDomain<T extends Serializable> {
    private T id;

    public T getId() {
        return id;
    }

    public void setId(T id) {
        this.id = id;
    }
}
