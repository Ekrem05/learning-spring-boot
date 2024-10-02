package com.example.aopdemo.dao;

import org.springframework.stereotype.Repository;

@Repository
public class MemebershipDAOImpl implements MembershipDAO{

    @Override
    public void addMembership() {
        System.out.println("Adding membership");
    }
}
