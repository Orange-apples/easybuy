package com.galaxy.easybuy.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * (AccountAddress)实体类
 *
 * @author makejava
 * @since 2020-05-30 16:40:33
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountAddress implements Serializable {
    private static final long serialVersionUID = 256167821068167028L;
    
    private Integer account_id;

    private String address;
    
    private String remark;


}