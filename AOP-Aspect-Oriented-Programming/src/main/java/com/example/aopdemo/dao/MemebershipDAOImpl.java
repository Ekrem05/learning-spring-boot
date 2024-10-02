package com.example.aopdemo.dao;

import org.springframework.stereotype.Repository;

@Repository
public class MemebershipDAOImpl implements MembershipDAO{

    @Override
    public void addAccount() {
        System.out.println("Adding account in memebershipDAO");
    }
}
