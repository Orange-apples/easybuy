package com.galaxy.easybuy.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.galaxy.easybuy.dao.OrderDao;
import com.galaxy.easybuy.entity.Order;
import com.galaxy.easybuy.service.OrderService;
import org.springframework.stereotype.Service;

@Service("orderService")
public class OrderServiceImpl extends ServiceImpl<OrderDao, Order> implements OrderService {
}
