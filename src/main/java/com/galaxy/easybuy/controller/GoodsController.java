package com.galaxy.easybuy.controller;

import com.galaxy.easybuy.service.GoodsService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * (Goods)表控制层
 *
 * @author makejava
 * @since 2020-05-29 22:26:35
 */
@RestController
@RequestMapping("/goods")
public class GoodsController {
    /**
     * 服务对象
     */
    @Resource
    private GoodsService goodsService;

}