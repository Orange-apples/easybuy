package com.galaxy.easybuy.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * (Account)实体类
 *
 * @author makejava
 * @since 2020-05-29 22:26:35
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account implements Serializable {
    private static final long serialVersionUID = 686150578170629455L;
    
    private Integer id;
    
    private String userName;
    
    private String password;
    
    private String name;
    
    private Integer sex;
    
    private String idCard;
    
    private String email;
    
    private String phone;



}