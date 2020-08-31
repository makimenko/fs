package com.makimenko.fs.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public abstract class RefData extends BaseDomain<String> implements Serializable {

    String name;

}
