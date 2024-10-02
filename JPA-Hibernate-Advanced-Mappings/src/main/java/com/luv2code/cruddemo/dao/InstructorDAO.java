package com.luv2code.cruddemo.dao;

import com.luv2code.cruddemo.entity.Instructor;

public interface InstructorDAO {

    void save(Instructor instructor);
    Instructor findById(int id);
    void delete(int id);
}
