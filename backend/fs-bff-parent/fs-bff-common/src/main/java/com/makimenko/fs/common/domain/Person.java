package com.makimenko.fs.common.domain;

import lombok.Data;

import java.time.LocalDate;

@Data
public abstract class Person extends BusinessData {

    private String name;
    private LocalDate birthDate;

}
