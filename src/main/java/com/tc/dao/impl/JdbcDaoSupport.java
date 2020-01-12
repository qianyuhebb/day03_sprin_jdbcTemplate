package com.tc.dao.impl;

import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * 时间：  2020/1/12
 * 创建者：  Administrator 钟文
 * 描述：   此类用于抽取dao中的重复代码
 * 参数：
 * 返回值：
 **/
public class JdbcDaoSupport {

    private JdbcTemplate jdbcTemplate;

   // private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        //this.dataSource = dataSource;
        if (jdbcTemplate == null){
            jdbcTemplate =  createJdbcTempLate(dataSource);
        }
    }

    private JdbcTemplate createJdbcTempLate(DataSource dataSource) {
        return    new JdbcTemplate(dataSource);
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
