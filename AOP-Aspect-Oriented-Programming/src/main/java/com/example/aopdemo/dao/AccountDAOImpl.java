package com.example.aopdemo.dao;

import com.example.aopdemo.model.Account;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDAOImpl implements AccountDAO {

    private String name;
    private String serviceCode;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getServiceCode() {
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        this.serviceCode = serviceCode;
    }

    @Override
    public void addAccount() {
        System.out.println("Adding account");
    }

    @Override
    public void removeAccount(String reason, String name, boolean remember) {

    }

    @Override
    public Account findAccount(String name) {
        Account result = new Account(12,name,300);
        return result;
    }
}
