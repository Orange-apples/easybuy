package com.galaxy.easybuy.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * (Category)实体类
 *
 * @author makejava
 * @since 2020-05-30 14:19:54
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(resultMap = "categoryMap",excludeProperty = {"parrentName","lName","sonCategory"})
public class Category implements Serializable {
    private static final long serialVersionUID = -75742202570497422L;
    
    private Integer id;
    
    private String name;
    
    private Integer l;

    private Integer parrentId;

    private String parrentName;

    private String lName;

    private List<Category> sonCategory;

    public void setL(Integer l){
        this.l = l;
        this.setlName(null);
    }

    public void setlName(String lName) {
       if(l==1)this.lName="一级分类";
       if(l==2)this.lName="二级分类";
       if(l==3)this.lName="三级分类";
    }
}