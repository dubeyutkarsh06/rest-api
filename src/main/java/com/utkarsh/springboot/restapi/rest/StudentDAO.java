package com.utkarsh.springboot.restapi.rest;

import java.util.List;

public interface StudentDAO {
    public List<Student> getStudentList();

    public Student getStudentById(Integer id);
}
