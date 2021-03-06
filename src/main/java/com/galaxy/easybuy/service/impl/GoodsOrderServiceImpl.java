package com.galaxy.easybuy.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.galaxy.easybuy.dao.GoodsOrderDao;
import com.galaxy.easybuy.entity.GoodsOrder;
import com.galaxy.easybuy.service.GoodsOrderService;
import org.springframework.stereotype.Service;

@Service("goodsOrderService")
public class GoodsOrderServiceImpl extends ServiceImpl<GoodsOrderDao, GoodsOrder> implements GoodsOrderService {
}
