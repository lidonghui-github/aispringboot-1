package com.southwind.controller;

import com.southwind.entity.Account;
import com.southwind.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/account")
public class AccountHandler {
    @Autowired
    AccountRepository accountRepository;

    @RequestMapping("/findAll")
   // @ResponseBody
    public List<Account> findAll(){
        return accountRepository.findAll();
    }

    @GetMapping("/findById/{id}")
    public Account findById(@PathVariable("id") Integer id){
        return accountRepository.findById(id);
    }

    @RequestMapping("/save")
    public void save(Account account){
        accountRepository.save(account);
    }

    @RequestMapping("/update")
    public void update(Account account){
        accountRepository.update(account);
    }

    @RequestMapping("/deleteById/{id}")
    public void deleteById(@PathVariable("id") Integer id){
        accountRepository.deleteById(id);
    }
}
