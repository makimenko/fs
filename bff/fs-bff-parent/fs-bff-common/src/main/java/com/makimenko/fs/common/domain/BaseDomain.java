package com.makimenko.fs.common.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public abstract class BaseDomain<T extends Serializable> implements Serializable {

    private T id;

}
