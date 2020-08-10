package com.makimenko.fs.persistence.mongodb.entity;

import com.makimenko.fs.common.domain.BusinessData;

import java.io.Serializable;

public abstract class BusinessEntity<T extends BusinessData> implements Serializable {

    public abstract T toDomain();

    public abstract void updateEntity(T dom);

}
