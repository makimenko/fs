package com.makimenko.fs.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

import java.io.Serializable;

@Data
public abstract class BaseDomain<T extends Serializable> implements Serializable {

    @Id
    @Indexed(unique = true)
    private T id;

}
