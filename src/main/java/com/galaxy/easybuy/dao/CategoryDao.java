package com.galaxy.easybuy.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.galaxy.easybuy.entity.Category;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (Category)表数据库访问层
 *
 * @author makejava
 * @since 2020-05-30 14:19:54
 */
public interface CategoryDao extends BaseMapper<Category> {

}