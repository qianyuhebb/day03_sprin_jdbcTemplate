package com.tc.dao;

import com.tc.domain.AccountDO;

/**
 * 时间：  2020/1/12
 * 创建者：  Administrator 钟文
 * 描述：
 * 参数：
 * 返回值：
 **/


public interface IaccountDao {

    AccountDO findAccountByid(Integer id);

    AccountDO findAccountByName(String name);

    void  updateAccount(AccountDO accountDO);
}
