package com.galaxy.easybuy.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.galaxy.easybuy.dao.GoodsDao;
import com.galaxy.easybuy.entity.Goods;
import com.galaxy.easybuy.service.GoodsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

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

    @Override
    public List<Goods> queryByL1Category(Integer categoryId) {
        return goodsDao.queryByL1Category(categoryId);
    }

    @Override
    public List<Goods> queryByL2Category(Integer categoryId) {
        return goodsDao.queryByL2Category(categoryId);
    }

    @Override
    public List<Goods> queryByL3Category(Integer categoryId) {
        return goodsDao.queryByL3Category(categoryId);
    }
}