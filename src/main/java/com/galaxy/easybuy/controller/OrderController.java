package com.galaxy.easybuy.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.galaxy.easybuy.component.CartItem;
import com.galaxy.easybuy.component.ConstantNum;
import com.galaxy.easybuy.entity.Account;
import com.galaxy.easybuy.entity.AccountAddress;
import com.galaxy.easybuy.entity.GoodsOrder;
import com.galaxy.easybuy.entity.Order;
import com.galaxy.easybuy.service.*;
import com.sun.org.apache.xpath.internal.operations.Or;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Resource
    OrderService orderService;
    @Resource
    GoodsService goodsService;
    @Resource
    GoodsOrderService goodsOrderService;
    @Resource
    AddressService addressService;

    /**
     * 查询我的订单
     */
    @RequestMapping("/myOrder")
    public Map myOrder(Model model, Integer current, HttpServletRequest request) {
        current = current == null ? 1 : current;
        Account loginAccount = (Account) request.getSession().getAttribute("loginAccount");
        //TODO 根据用户id查询订单
        Page<Order> page = orderService.page(new Page<Order>(current, ConstantNum.PAGESIZE), new QueryWrapper<Order>().eq("account_id", 1));
        HashMap<String, Object> map = new HashMap<>();
        map.put("OrderList", page.getRecords());
        map.put("total", page.getTotal());
        map.put("current", page.getCurrent());
        map.put("pages", page.getPages());
        return map;
    }

    /**
     * 查询所有有订单
     */
    @RequestMapping("/allOrder")
    public Map allOrder(Model model, HttpServletRequest request, Integer current) {
        current = current == null ? 1 : current;
        Page<Order> page = orderService.page(new Page<Order>(current, ConstantNum.PAGESIZE), null);
        HashMap<String, Object> map = new HashMap<>();
        map.put("OrderList", page.getRecords());
        map.put("total", page.getTotal());
        map.put("current", page.getCurrent());
        map.put("pages", page.getPages());
        return map;
    }

    /**
     * 添加订单信息
     * @param accountAddress,用户选择的地址
     * @param cart,购物车的json，包括id,count
     * @return order 添加完成后将此订单返回
     */
    @RequestMapping("/create")
    public Order create(String accountAddress, AccountAddress newAdderss, String cart, HttpServletRequest request) throws JsonProcessingException {
        //接收购物车信息
        ObjectMapper om = new ObjectMapper();
        List<CartItem> cartItems = om.readValue(cart, new TypeReference<List<CartItem>>() {
        });
        //订单信息
        Order order = new Order();
        Account loginAccount = (Account) request.getSession().getAttribute("loginAccount");
        order.setAccountId(loginAccount.getId());
        order.setAccountName(loginAccount.getUserName());
        order.setCreateTime(new Date());
        order.setOrderNum(new Date().getTime() + "");
        if(accountAddress!=null && accountAddress != ""){
            order.setAddress(accountAddress);
        }else{
            newAdderss.setAccount_id(loginAccount.getId());
            addressService.save(newAdderss);
            order.setAddress(newAdderss.getAddress());
        }
        Double price = 0.0;
        for (CartItem cartItem : cartItems) {
          price += goodsService.getById(cartItem.getId()).getPrice() * cartItem.getCount();
        }
        order.setOrderPrice(price);
        orderService.save(order);
        //订单详情信息
        for (CartItem cartItem : cartItems) {
            GoodsOrder goodsOrder = new GoodsOrder();
            goodsOrder.setGoodsId(cartItem.getId());
            goodsOrder.setOrderId(order.getId());
            goodsOrder.setCount(cartItem.getCount());
            goodsOrderService.save(goodsOrder);
        }
        return order;
    }

}
