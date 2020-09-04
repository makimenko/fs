package com.makimenko.fs.web.service;

import com.makimenko.fs.domain.RefData;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ServiceUtils {

    public static <T extends RefData> List<T> refList(List<String> ids, Function<String, T> findById) {
        if (ids != null) {
            return ids.stream()
                    .map(findById)
                    .filter(i -> i != null)
                    .collect(Collectors.toList());
        }
        return null;
    }

}
