package com.galaxy.easybuy.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.galaxy.easybuy.component.ConstantNum;
import com.galaxy.easybuy.component.MsgResult;
import com.galaxy.easybuy.entity.Category;
import com.galaxy.easybuy.service.CategoryService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * (Category)表控制层
 *
 * @author makejava
 * @since 2020-05-30 14:19:54
 */
@RestController
@RequestMapping("/category")
public class CategoryController {
    /**
     * 服务对象
     */
    @Resource
    private CategoryService categoryService;

    @RequestMapping("/queryAllByIndex")
    public MsgResult queryAllByIndex(){
        List<Category> categoryList = categoryService.queryAllByIndex();
        return new MsgResult(1,categoryList);
    }

    @RequestMapping("/queryAll")
    public MsgResult queryAll(Integer current) {
        current = current==null?1:current;
        Page<Category> page = categoryService.page(new Page<Category>(current, ConstantNum.PAGESIZE));
        Map<String, Object> map = new HashMap<>();
        map.put("total",page.getTotal());
        map.put("pages",page.getPages());
        map.put("current",page.getCurrent());
        map.put("categoryList",page.getRecords());
        return new MsgResult(1,map);
    }

    @RequestMapping("/queryL1")
    public MsgResult queryL1(){
        return new MsgResult(1,categoryService.list(new QueryWrapper<Category>()
                .eq("l",1)
        ));
    }
    @RequestMapping("/queryL2")
    public MsgResult queryL2(Integer parrentId){
        parrentId = parrentId==null?0:parrentId;
        QueryWrapper<Category> wrapper = new QueryWrapper<Category>().eq("l",2);
        if (parrentId!=0)wrapper.eq("parrent_id",parrentId);
        return new MsgResult(1, categoryService.list(wrapper));
    }
    @RequestMapping("/queryL3")
    public MsgResult queryL3(Integer parrentId){
        parrentId = parrentId==null?0:parrentId;
        QueryWrapper<Category> wrapper = new QueryWrapper<Category>().eq("l",3);
        if (parrentId!=0)wrapper.eq("parrent_id",parrentId);
        return new MsgResult(1, categoryService.list(wrapper));
    }
    @RequestMapping("/insert")
    public MsgResult insert(Category category){
     try{
         if(categoryService.save(category)){
             return new MsgResult(1,category);
         }else{
             return new MsgResult(0,"执行失败！",category);
         }
     }catch (Exception e){
         return new MsgResult(0,"执行失败！",null);
     }
    }

    @RequestMapping("/delete")
    public MsgResult delete(Integer id){
        if(categoryService.removeById(id)){
            return new MsgResult(1,id);
        }else{
            return new MsgResult(0,"执行失败！",id);
        }

    }

}