package com.makimenko.fs.domain.book;


import com.makimenko.fs.domain.RefData;
import lombok.Data;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@ToString(callSuper = true)
public class BookGenre extends RefData {

}