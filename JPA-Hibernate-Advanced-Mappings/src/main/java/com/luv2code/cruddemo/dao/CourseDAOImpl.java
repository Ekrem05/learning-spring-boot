package com.luv2code.cruddemo.dao;

import com.luv2code.cruddemo.entity.Course;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class CourseDAOImpl implements CourseDAO {
    private EntityManager em;

    public CourseDAOImpl(EntityManager em) {
        this.em = em;
    }

    @Transactional
    @Override
    public void save(Course course) {
        em.persist(course);
    }

    @Override
    public List<Course> findWithSpecifiedInstructor(int instructorId) {
        TypedQuery<Course> query = em
                .createQuery("from Course where instructor.id = :param",Course.class);

        List<Course> courses = query.setParameter("param", instructorId).getResultList();
        return courses;
    }

    @Override
    public List<Course> getAllCoursesWithStudents() {
        TypedQuery<Course> query = em
                .createQuery("select c from Course c JOIN FETCH c.students",Course.class);

        List<Course> courses = query.getResultList();
        return courses;
    }
}
