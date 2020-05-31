package com.galaxy.easybuy.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.galaxy.easybuy.dao.AddressDao;
import com.galaxy.easybuy.entity.AccountAddress;
import com.galaxy.easybuy.service.AddressService;
import org.springframework.stereotype.Service;

@Service("addressService")
public class AddressServiceImpl extends ServiceImpl<AddressDao, AccountAddress> implements AddressService {
}
