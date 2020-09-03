package com.makimenko.fs.persistence.config;

import com.makimenko.fs.persistence.repository.BookGenreRepository;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

import static java.util.Arrays.asList;

@Configuration
@EnableCaching
public class CacheConfig {

    @Bean
    public CacheManager cacheManager() {
        SimpleCacheManager cacheManager = new SimpleCacheManager();
        cacheManager.setCaches(asList(
                new ConcurrentMapCache(BookGenreRepository.CACHE_ID))
        );
        return cacheManager;
    }

}
