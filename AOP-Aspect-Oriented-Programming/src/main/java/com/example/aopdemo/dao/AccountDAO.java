package com.example.aopdemo.dao;

import com.example.aopdemo.model.Account;

public interface AccountDAO {
     String getName();

     void setName(String name);

     String getServiceCode();

     void setServiceCode(String serviceCode);

    void addAccount();

    void removeAccount(String reason, String name,boolean remember);

    Account findAccount(String name) throws Exception;
}
