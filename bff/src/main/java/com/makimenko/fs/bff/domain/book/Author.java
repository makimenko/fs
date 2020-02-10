package com.makimenko.fs.bff.domain.book;

import com.makimenko.fs.bff.domain.Person;

public class Author extends Person {

    String licenseId;

    public String getLicenseId() {
        return licenseId;
    }

    public void setLicenseId(String licenseId) {
        this.licenseId = licenseId;
    }
}
