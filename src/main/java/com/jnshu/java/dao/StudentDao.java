package com.jnshu.java.dao;

import java.util.List;

import com.jnshu.java.model.Student;

public interface StudentDao {
    List<Student> findAll();

    Student findById(long id);

    Student findOne(String property, String key);

    boolean deleteAll();

    boolean deleteById(long id);

    boolean deleteOne(String property, String key);

    boolean createStudents(Student students);

    boolean updateStudents(Student students);
}
