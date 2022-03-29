package com.firmys.gameservice.inventory.service.currency;

import com.firmys.gameservice.common.GameService;
import com.firmys.gameservice.common.GameServiceProperties;
import com.firmys.gameservice.common.ServiceConstants;
import com.firmys.gameservice.inventory.service.data.Currency;
import com.firmys.gameservice.inventory.service.inventory.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@EnableConfigurationProperties(GameServiceProperties.class)
public class CurrencyService implements GameService<Currency> {
    public final String cacheName = ServiceConstants.CURRENCY;
    public final String cacheManagerName = ServiceConstants.CURRENCY + "CacheManager";

    @Autowired
    CurrencyRepository repository;

    @Cacheable(value = cacheName, cacheManager = cacheManagerName)
    public Iterable<Currency> findAll(Sort sort) {
        return repository.findAll(sort);
    }

    @CachePut(value = cacheName, cacheManager = cacheManagerName)
    public Currency save(Currency entity) {
        return repository.save(entity);
    }

    @CacheEvict(value = cacheName, cacheManager = cacheManagerName)
    public void delete(Currency entity) {
        repository.delete(entity);
    }

    @Cacheable(value = cacheName, cacheManager = cacheManagerName)
    public Page<Currency> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @CachePut(value = cacheName, cacheManager = cacheManagerName)
    public <S extends Currency> Iterable<S> saveAll(Iterable<S> entities) {
        return repository.saveAll(entities);
    }

    public Optional<Currency> findById(Integer integer) {
        return repository.findById(integer);
    }

    public boolean existsById(Integer integer) {
        return repository.existsById(integer);
    }

    @Cacheable(value = cacheName, cacheManager = cacheManagerName)
    public Iterable<Currency> findAll() {
        return repository.findAll();
    }

    public Iterable<Currency> findAllById(Iterable<Integer> integers) {
        return repository.findAllById(integers);
    }

    public long count() {
        return repository.count();
    }

    @CacheEvict(value = cacheName, cacheManager = cacheManagerName)
    public void deleteById(Integer integer) {
        repository.deleteById(integer);
    }

    @CacheEvict(value = cacheName, cacheManager = cacheManagerName)
    public void deleteAllById(Iterable<? extends Integer> integers) {
        repository.deleteAllById(integers);
    }

    @CacheEvict(value = cacheName, cacheManager = cacheManagerName)
    public void deleteAll(Iterable<? extends Currency> entities) {
        repository.deleteAll(entities);
    }

    @CacheEvict(value = cacheName, cacheManager = cacheManagerName)
    public void deleteAll() {
        repository.deleteAll();
    }

}
