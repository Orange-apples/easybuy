package com.galaxy.easybuy.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.galaxy.easybuy.entity.Goods;

import java.util.List;

/**
 * (Goods)表服务接口
 *
 * @author makejava
 * @since 2020-05-29 22:26:35
 */
public interface GoodsService extends IService<Goods> {

    List<Goods> queryByL1Category(Integer categoryId);

    List<Goods> queryByL2Category(Integer categoryId);

    List<Goods> queryByL3Category(Integer categoryId);
}