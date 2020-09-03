package com.makimenko.fs.persistence.dao;

import com.makimenko.fs.domain.RefData;
import com.makimenko.fs.persistence.exception.DaoException;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public class DaoUtils {

    public static <T extends RefData> List<T> refList(List<String> ids, Function<String, Optional<T>> findById) {
        if (ids != null) {
            return ids.stream()
                    .map(findById)
                    .map(i -> i.orElseThrow(() -> new DaoException("Reference ID not exists")))
                    .filter(i -> i != null)
                    .collect(Collectors.toList());
        }
        return null;
    }

}
