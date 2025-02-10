package com.utkarsh.springboot.restapi.employee;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO{

    private EntityManager entityManager;

    @Autowired
    public EmployeeDAOImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findAll() {
        TypedQuery<Employee> query = this.entityManager.createQuery("from Employee ", Employee.class);
        return query.getResultList();
    }

    @Override
    public Employee findById(Integer id) {
        Employee employee = this.entityManager.find(Employee.class,id);
        return employee;
    }

    @Override
    public Employee save(Employee employee) {
        Employee dbEmployee = this.entityManager.merge(employee);

        return dbEmployee;
    }

    @Override
    public void delete(Integer id) {
        Employee employee = this.entityManager.find(Employee.class,id);
        this.entityManager.remove(employee);
    }
}
