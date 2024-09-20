package com.ecommerce.catalog.domain.model.price.port.in;

import java.util.List;

import com.ecommerce.catalog.domain.model.price.Price;

public interface IPriceService {
    public Price savePrice(Price price);
    public Price findPriceById(String id);
    public List<Price> findAllPrices();
}
