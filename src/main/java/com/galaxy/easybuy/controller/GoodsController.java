package com.galaxy.easybuy.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.galaxy.easybuy.component.ConstantNum;
import com.galaxy.easybuy.entity.Goods;
import com.galaxy.easybuy.service.GoodsService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

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

    @RequestMapping("/queryAll")
    public Map queryAll(Integer current,Goods goods){
        current = current==null?1:current;
        QueryWrapper<Goods> wrapper = new QueryWrapper<>();
        if(goods.getName()!=null&&goods.getName()!=""){
            wrapper.like("name",goods.getName());
        }
        HashMap<String, Object> map = new HashMap<>();
        Page<Goods> page = goodsService.page(new Page<Goods>(current, ConstantNum.PAGESIZE), wrapper);
        map.put("total",page.getTotal());
        map.put("pages",page.getPages());
        map.put("current",page.getCurrent());
        map.put("goodsList",page.getRecords());
        return map;
    }
    @RequestMapping("queryById")
    public Goods queryById(Integer id){
        return goodsService.getById(id);
    }




    @RequestMapping("/queryByCategory")
    public List<Goods> queryByCategory(Integer l, Integer categoryId) {
        List<Goods> goodsList = new LinkedList<Goods>();
        if (l == 1) {
            goodsList = goodsService.queryByL1Category(categoryId);
        } else if (l == 2) {
            goodsList = goodsService.queryByL2Category(categoryId);
        } else if (l == 3) {
            goodsList = goodsService.queryByL3Category(categoryId);
        }
        return goodsList;
    }

}