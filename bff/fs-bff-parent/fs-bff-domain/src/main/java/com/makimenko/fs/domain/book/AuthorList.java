package com.makimenko.fs.domain.book;

import com.makimenko.fs.domain.BusinessData;
import lombok.Data;
import lombok.ToString;

@Data
@ToString(callSuper = true)
public class AuthorList extends BusinessData {

    private String name;

}
