package com.wqkeep.service.impl;

import com.wqkeep.dao.IProductDao;
import com.wqkeep.domain.Product;
import com.wqkeep.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProductServiceImpl implements IProductService {

    @Autowired
    private IProductDao proDuctDao;

    @Override
    public List<Product> findAll() {
        return proDuctDao.findAll();
    }

    @Override
    public void save(Product product) {
        proDuctDao.save(product);
    }
}