package com.keafmd.test;

import com.keafmd.dao.AccountDao;
import com.keafmd.domain.Account;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;
public class TestMybatis {

    private InputStream in;
    private SqlSessionFactory factory;
    private SqlSession session;
    private AccountDao accountDao;

    @Before
    public void init() throws Exception{
        //加载配置文件
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //创建SqlSessionFactory对象
        factory = new SqlSessionFactoryBuilder().build(in);
        //创建SqlSession对象
        session = factory.openSession();
        //获取到代理对象
        accountDao = session.getMapper(AccountDao.class);
    }

    @After
    public void destory() throws Exception{
        session.commit();
        session.close();
        in.close();
    }

    /**
     * 查询所有
     */
    @Test
    public void run1(){
        List<Account> accounts = accountDao.findAll();
        for (Account account : accounts) {
            System.out.println(account);
        }
    }

    /**
     * 测试保存
     */
    @Test
    public void saveAccount(){
        Account account = new Account();
        account.setName("毛利小五郎");
        account.setMoney(800.00);
//        account.setMoney(800d);

        accountDao.saveAccount(account);
    }
}