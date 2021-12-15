package com.keafmd.dao;

import com.keafmd.domain.Account;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountDao {

    //查询所有账户
    @Select("select * from account")
    public List<Account> findAll();

    //保存账户
    @Insert("insert into account(name,money) values(#{name},#{money})")
    public void saveAccount(Account account);


    //@Insert("insert into account(name,money) values(#{name},#{money})")
    @Update("update account set money = money + 10 where id > 0")
    public void moneyUpUp();

}

