package com.kuv2xode.cruddemo.dao;

import com.kuv2xode.cruddemo.entity.Student;

import java.util.List;

public interface StudentDAO {

    void save(Student student);

    Student getById(int id);

    List<Student> getAll();

    List<Student> getByLastName(String lastName);

    Student update(Student student);

    void delete(int id);
}
