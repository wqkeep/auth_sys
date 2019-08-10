package com.wqkeep.service;

import com.wqkeep.domain.Orders;

import java.util.List;

public interface IOrdersService {

    List<Orders> findAllByPage(int page, int size) throws Exception;

    Orders findById(String id) throws Exception;
}
