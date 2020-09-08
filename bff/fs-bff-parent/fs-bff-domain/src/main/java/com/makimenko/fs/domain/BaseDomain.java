package com.makimenko.fs.domain;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

import java.io.Serializable;

@Data
public abstract class BaseDomain<T extends Serializable> implements Serializable {

    @Id
    @JsonSerialize(using= ToStringSerializer.class)
    private T id;

}
