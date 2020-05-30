package com.galaxy.easybuy.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.galaxy.easybuy.dao.AccountDao;
import com.galaxy.easybuy.entity.Account;
import com.galaxy.easybuy.service.AccountService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * (Account)表服务实现类
 *
 * @author makejava
 * @since 2020-05-29 22:26:35
 */
@Service("accountService")
public class AccountServiceImpl extends ServiceImpl<AccountDao, Account> implements AccountService {
    @Resource
    private AccountDao accountDao;

}