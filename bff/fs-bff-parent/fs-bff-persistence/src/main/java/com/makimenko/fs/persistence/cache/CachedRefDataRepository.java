package com.makimenko.fs.persistence.cache;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public interface CachedRefDataRepository<T> extends MongoRepository<T, String> {

    @Cacheable
    @Override
    Optional<T> findById(String s);

    default <S> List<T> refDataList(List<String> list) {
        if (list != null) {
            return list.stream()
                    .map(id -> this.findById(id).orElse(null))
                    .filter(i -> i != null)
                    .collect(Collectors.toList());
        }
        return null;
    }

}
