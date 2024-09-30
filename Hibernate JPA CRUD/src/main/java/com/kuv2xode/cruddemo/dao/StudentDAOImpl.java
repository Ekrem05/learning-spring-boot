package com.kuv2xode.cruddemo.dao;

import com.kuv2xode.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO {
    private EntityManager em;

    public StudentDAOImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    @Transactional
    public void save(Student student) {
        em.persist(student);
    }

    @Override
    public Student getById(int id) {
        return em.find(Student.class, id);
    }

    @Override
    public List<Student> getAll() {
        TypedQuery<Student> query = em.createQuery("FROM Student",Student.class);
        return query.getResultList();
    }

    @Override
    public List<Student> getByLastName(String lastName) {
        TypedQuery<Student> query = em.createQuery("from Student Where lastName = :param",Student.class);
        query.setParameter("param", lastName);
        return query.getResultList();
    }

    @Override
    @Transactional
    public Student update(Student student) {
        return em.merge(student);
    }

    @Override
    public void delete(int id) {
        Student student = em.find(Student.class, id);
        em.remove(student);
    }
}