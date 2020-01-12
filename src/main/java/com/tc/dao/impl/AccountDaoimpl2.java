package com.tc.dao.impl;

import com.tc.dao.IaccountDao;
import com.tc.domain.AccountDO;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.util.List;

/**
 * 时间：  2020/1/12
 * 创建者：  Administrator 钟文
 * 描述：     spring  自带的JdbcDaoSupport
 * 参数：
 * 返回值：
 **/
public class AccountDaoimpl2   extends JdbcDaoSupport {

    public AccountDO findAccountByid(Integer id) {
        List<AccountDO> acs = getJdbcTemplate().query("select * from account where id=?",
                new BeanPropertyRowMapper<AccountDO>(AccountDO.class),id);

        return acs.isEmpty()?null:acs.get(0);
    }

    public AccountDO findAccountByName(String name) {
        List<AccountDO> acs = getJdbcTemplate().query("select * from account where name=?",
                new BeanPropertyRowMapper<AccountDO>(AccountDO.class),name);

        if (acs.isEmpty()){
            return  null;
        }
        if (acs.size()>0){

            throw  new RuntimeException("结果集不唯一");
        }

        return acs.get(0);
    }

    public void updateAccount(AccountDO accountDO) {
        getJdbcTemplate().update("update account set name=?,money=?  where id= ?",accountDO.getName(),accountDO.getMoney()
               ,accountDO.getId());
    }
}
