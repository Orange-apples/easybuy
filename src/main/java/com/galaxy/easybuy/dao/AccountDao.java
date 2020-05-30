package com.galaxy.easybuy.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.galaxy.easybuy.entity.Account;
import com.galaxy.easybuy.entity.AccountAddress;

import java.util.List;

/**
 * (Account)表数据库访问层
 *
 * @author makejava
 * @since 2020-05-29 22:26:35
 */
public interface AccountDao extends BaseMapper<Account> {


    List<AccountAddress> getAccountAddress(Integer id);
}