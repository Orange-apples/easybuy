package com.galaxy.easybuy.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.galaxy.easybuy.entity.Account;
import com.galaxy.easybuy.entity.AccountAddress;

import java.util.List;

/**
 * (Account)表服务接口
 *
 * @author makejava
 * @since 2020-05-29 22:26:35
 */
public interface AccountService extends IService<Account> {


    List<AccountAddress> getAccountAddress(Integer id);
}