package com.makimenko.fs.web.service.book;

import org.bson.types.ObjectId;

import java.util.List;

public interface StandardService<T, L>  {

    List<L> find(T template);

    T get(ObjectId id);

    T save(T doc);

}
