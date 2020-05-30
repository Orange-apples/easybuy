package com.galaxy.easybuy.controller;

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
    public List<AccountAddress> getAccountAddress(HttpServletRequest request){
        //TODO 根据用户id查询地址
        //Account loginAccount = (Account) request.getSession().getAttribute("loginAccount");

        return accountService.getAccountAddress(1);
    }
}