package com.wqkeep.service;

import com.wqkeep.domain.Product;

import java.util.List;

public interface IProductService {

    public List<Product> findAll();

    void save(Product product);
}
