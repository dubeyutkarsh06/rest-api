package com.utkarsh.springboot.restapi.rest;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO{

    public EntityManager entityManager;

    @Autowired
    public StudentDAOImpl(EntityManager theEntityManager){
        this.entityManager = theEntityManager;
    }

    @Override
    public List<Student> getStudentList() {
        TypedQuery<Student> query = this.entityManager.createQuery("FROM Student ", Student.class);

        return query.getResultList();
    }

    @Override
    public Student getStudentById(Integer id) {
        Student ss = this.entityManager.find(Student.class, id);

        return ss;
    }
}
