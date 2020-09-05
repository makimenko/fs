package com.makimenko.fs.web.service.book;

import java.util.List;

public interface RefDataService<T> {

    List<T> find(T template);

    T get(String id);

    T save(T doc);

}
