package com.galaxy.easybuy.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GoodsOrder {
    private Integer id;

    private Integer orderId;

    private Integer goodsId;

    private Integer count;

    private Goods goods;
}
