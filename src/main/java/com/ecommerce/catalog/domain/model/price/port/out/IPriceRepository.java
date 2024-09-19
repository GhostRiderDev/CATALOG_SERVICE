package com.ecommerce.catalog.domain.model.price.port.out;

import java.util.List;

import com.ecommerce.catalog.domain.model.price.Price;

/**
 * IPriceRepository
 */
public interface IPriceRepository {
    List<Price> findAll();
    Optional<Price> findById(String id);
    Price save(Price price);
    Price updateById(String id, Price price);
    Price deleteById(String id);
}