package com.galaxy.easybuy.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName(/*excludeProperty = {"goodsList"},*/resultMap = "orderMap",value = "`order`")
public class Order {
    private Integer id;

    private Integer accountId;

    private String orderNum;

    private Double orderPrice;

    private String address;

    private String accountName;

    private Date createTime;

    private List<GoodsOrder> goodsOrder;

//    private List<Goods> goodsList;
}
