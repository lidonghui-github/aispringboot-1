package com.southwind.repository.impl;

import com.southwind.entity.Account;
import com.southwind.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class AccountRepositoryImpl implements AccountRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public List<Account> findAll() {
        return jdbcTemplate.query("select * from account",new BeanPropertyRowMapper<>(Account.class));
    }

    @Override
    public Account findById(Integer id) {
        return jdbcTemplate.queryForObject("select * from account where id =?",new BeanPropertyRowMapper<>(Account.class),id);
    }

    @Override
    public void save(Account account) {
        jdbcTemplate.update("insert into account(name) values (?)",account.getName());
    }

    @Override
    public void update(Account account) {
        jdbcTemplate.update("update account set name = ? where id = ?",account.getName(),account.getId());
    }

    @Override
    public void deleteById(Integer id) {
        jdbcTemplate.update("delete from account where id = ?",id);
    }
}
