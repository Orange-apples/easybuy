package com.galaxy.easybuy.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.galaxy.easybuy.component.MsgResult;
import com.galaxy.easybuy.entity.Account;
import com.galaxy.easybuy.entity.AccountAddress;
import com.galaxy.easybuy.service.AccountService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * (Account)表控制层
 *
 * @author makejava
 * @since 2020-05-29 22:26:35
 */
@RestController
@RequestMapping("/account")
public class AccountController {
    /**
     * 服务对象
     */
    @Resource
    private AccountService accountService;

    @RequestMapping("/getAccountAddress")
    public MsgResult getAccountAddress(HttpServletRequest request){
        //TODO 根据用户id查询地址
        //Account loginAccount = (Account) request.getSession().getAttribute("loginAccount");

        return new MsgResult(1,accountService.getAccountAddress(1));
    }
    @RequestMapping("login")
    public MsgResult login(Account account,HttpServletRequest request){
        Account loginAccount = accountService.getOne(new QueryWrapper<Account>().eq("user_name", account.getUserName()).eq("password", account.getPassword()));
        if (loginAccount==null){
            return new MsgResult(0,"用户名密码错误",null);
        }else{
            request.getSession().setAttribute("loginAccount",loginAccount);
            return new MsgResult(1,loginAccount);
        }

    }

}