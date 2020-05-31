package com.galaxy.easybuy.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.galaxy.easybuy.entity.Goods;

import java.util.List;

/**
 * (Goods)表数据库访问层
 *
 * @author makejava
 * @since 2020-05-29 22:26:35
 */
public interface GoodsDao extends BaseMapper<Goods> {

    List<Goods> queryByL1Category(Integer categoryId);

    List<Goods> queryByL2Category(Integer categoryId);

    List<Goods> queryByL3Category(Integer categoryId);
}