package com.galaxy.easybuy.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * (Goods)实体类
 *
 * @author makejava
 * @since 2020-05-29 22:26:34
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Goods implements Serializable {
    private static final long serialVersionUID = 437970384229947592L;
    
    private Integer id;
    
    private String name;
    
    private Double price;
    
    private Integer stock;
    
    private String content;
    
    private String img;
    
    private Integer categoryId;
    
    private Object createTime;


}