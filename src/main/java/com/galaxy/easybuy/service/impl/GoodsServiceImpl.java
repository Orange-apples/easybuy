package com.galaxy.easybuy.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.galaxy.easybuy.dao.GoodsDao;
import com.galaxy.easybuy.entity.Goods;
import com.galaxy.easybuy.service.GoodsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * (Goods)表服务实现类
 *
 * @author makejava
 * @since 2020-05-29 22:26:35
 */
@Service("goodsService")
public class GoodsServiceImpl extends ServiceImpl<GoodsDao,Goods> implements GoodsService {
    @Resource
    private GoodsDao goodsDao;

}