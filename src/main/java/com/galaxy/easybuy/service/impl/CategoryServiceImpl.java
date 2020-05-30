package com.galaxy.easybuy.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.galaxy.easybuy.entity.Category;
import com.galaxy.easybuy.dao.CategoryDao;
import com.galaxy.easybuy.service.CategoryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Category)表服务实现类
 *
 * @author makejava
 * @since 2020-05-30 14:19:54
 */
@Service("categoryService")
public class CategoryServiceImpl extends ServiceImpl<CategoryDao,Category> implements CategoryService {

}