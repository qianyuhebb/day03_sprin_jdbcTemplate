package com.tc.jdbcTemplate;

import com.tc.dao.IaccountDao;
import com.tc.domain.AccountDO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.sql.DriverManager;
import java.util.List;



/**
 * 时间：  2020/1/11
 * 创建者：  Administrator 钟文
 * 描述：
 * 参数：
 * 返回值：
 **/
public class test {


    public static void main(String[] args) {

        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
      //  JdbcTemplate jt = ac.getBean("JdbcTemplate", JdbcTemplate.class);

        IaccountDao accountdao = (IaccountDao) ac.getBean("accountDao", IaccountDao.class);

        AccountDO byid = accountdao.findAccountByid(3);
        System.out.println(byid);


        /*   DriverManagerDataSource dmm =new DriverManagerDataSource();
        dmm.setDriverClassName("com.mysql.jdbc.Driver");
        dmm.setUrl("jdbc:mysql://localhost:3306/eesy?characterEncoding=utf8");
        dmm.setUsername("root");
        dmm.setPassword("root");
        JdbcTemplate jt =new JdbcTemplate(dmm);*/

       // jt.execute("insert  into account(name,money) values ('ccc','366633')");

        //保存
       // jt.update("insert into account(name,money) values (?,?)","ddd","5555");
        //更新
       // jt.update("update account set name =?,money=?where id=?","eee","567",4);
        //删除
       // jt.update("delete from account where id =?","4");
        //查询

           //查询所有
       /*List<AccountDO> acs= jt.query("select * from account where id>?",
                new BeanPropertyRowMapper<AccountDO>(AccountDO.class),1);
        for (AccountDO ac : acs) {
            System.out.println(ac.toString());
        }*/
           //查询一个

      /*  List<AccountDO> ww = jt.query("select * from account where id =?" ,
                new BeanPropertyRowMapper<AccountDO>(AccountDO.class)
                ,1);

        System.out.println(ww.get(0).toString());*/
        //查询返回一行一列
        /*Integer integer = jt.queryForObject("select count(*) from account where id>?", Integer.class, 1);
        System.out.println(integer);*/


    }


}
