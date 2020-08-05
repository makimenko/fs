package com.makimenko.fs.bff.dao.mongodb.entity;

import com.makimenko.fs.bff.domain.BusinessData;

import java.io.Serializable;

public abstract class BusinessEntity<T extends BusinessData> implements Serializable {

    public abstract T toDomain();

    public abstract void updateEntity(T dom);

}
