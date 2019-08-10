package com.wqkeep.service.impl;

import com.github.pagehelper.PageHelper;
import com.wqkeep.dao.IOrdersDao;
import com.wqkeep.domain.Orders;
import com.wqkeep.service.IOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class OrdersServiceImpl implements IOrdersService {

    @Autowired
    private IOrdersDao ordersDao;

    @Override
    public List<Orders> findAllByPage(int page, int size) throws Exception {
        PageHelper.startPage(page, size);
        return ordersDao.findAll();
    }

    @Override
    public Orders findById(String id) throws Exception {
        return ordersDao.findById(id);
    }

}
