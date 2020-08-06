package com.makimenko.fs.common.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.UUID;

@Data
public abstract class BusinessData extends BaseDomain<UUID> implements Serializable {

}
