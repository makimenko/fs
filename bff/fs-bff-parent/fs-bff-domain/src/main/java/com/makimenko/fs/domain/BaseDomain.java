package com.makimenko.fs.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.io.Serializable;

@Data
public abstract class BaseDomain<T extends Serializable> implements Serializable {

    @Id
    private T id;

}
