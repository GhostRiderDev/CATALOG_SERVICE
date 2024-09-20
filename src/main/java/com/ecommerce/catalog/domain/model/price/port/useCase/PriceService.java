package com.ecommerce.catalog.domain.model.price.port.useCase;

import java.util.List;

import com.ecommerce.catalog.domain.constant.Constant;
import com.ecommerce.catalog.domain.exception.NotFoundException;
import com.ecommerce.catalog.domain.model.price.Price;
import com.ecommerce.catalog.domain.model.price.port.in.IPriceService;
import com.ecommerce.catalog.domain.model.price.port.out.IPriceRepository;


public class PriceService implements IPriceService {

    private final IPriceRepository priceRepository;

    public PriceService(IPriceRepository priceRepository) {
        this.priceRepository = priceRepository;
    }

    @Override
    public Price savePrice(Price price) {
       return priceRepository.save(price);
    }

    @Override
    public Price findPriceById(String id) {
       return priceRepository.findById(id).orElseThrow(() -> new NotFoundException(Constant.PRICE_NOT_FOUND));    
    }

    @Override
    public List<Price> findAllPrices() {
        return priceRepository.findAll();
    }


    
}
