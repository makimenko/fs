package com.makimenko.fs.domain;

import lombok.Data;
import org.bson.types.ObjectId;

import java.io.Serializable;

@Data
public abstract class BusinessData extends BaseDomain<ObjectId> implements Serializable {

}
