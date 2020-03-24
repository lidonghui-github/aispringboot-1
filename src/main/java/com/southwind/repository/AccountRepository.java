package com.southwind.repository;

import com.southwind.entity.Account;

import java.util.List;

public interface AccountRepository {
    public List<Account> findAll();

    public Account findById(Integer id);

    public void save(Account account);

    public void update(Account account);

    public void deleteById(Integer id);
}
