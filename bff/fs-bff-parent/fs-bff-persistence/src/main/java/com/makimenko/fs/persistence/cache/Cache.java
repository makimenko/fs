package com.makimenko.fs.persistence.cache;

import com.makimenko.fs.domain.RefData;

import java.util.List;
import java.util.stream.Collectors;

public interface Cache<T extends RefData> {

    T find(String id);

    default List<T> findAll(List<String> ids) {
        if (ids != null) {
            return ids.stream()
                    .map((i) -> {
                        return this.find(i);
                    })
                    .filter(i -> i != null)
                    .collect(Collectors.toList());
        }
        return null;
    }

}
