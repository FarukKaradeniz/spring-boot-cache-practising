package com.farukkaradeniz.cachepractising;

import com.github.benmanes.caffeine.cache.Caffeine;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.caffeine.CaffeineCache;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Configuration
@EnableCaching
public class CacheConfig extends CachingConfigurerSupport {

    @Bean
    public CacheManager cacheManager() {
        CaffeineCacheManager cacheManager = new CaffeineCacheManager();

        var caches = List.of(
                this.buildCache("1minCache", 2000L, 1L, TimeUnit.MINUTES),
                this.buildCache("2minCache", 2000L, 2L, TimeUnit.MINUTES),
                this.buildCache("30secCache", 3500L, 30L, TimeUnit.SECONDS)
        );

        caches.forEach(cache -> {
            cacheManager.registerCustomCache(cache.getName(), cache.getNativeCache());
        });

        return cacheManager;
    }

    private CaffeineCache buildCache(String cacheName, Long maxSize, Long ttl, TimeUnit ttlUnit) {

        var cacheBuilder = Caffeine.newBuilder();

        // TTL
        if (ttl != null && ttl > 0 && ttlUnit != null) {
            cacheBuilder.expireAfterWrite(ttl, ttlUnit);
        }

        // Max size
        if (maxSize != null && maxSize > 0) {
            cacheBuilder.maximumSize(maxSize);
        }

        cacheBuilder.recordStats();

        return new CaffeineCache(cacheName, cacheBuilder.build());
    }

}
