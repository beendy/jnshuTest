package com.jnshu.java.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jnshu.java.dao.StudentDao;
import com.jnshu.java.model.Student;

@Controller
@RestController
public class studentController {
    @Autowired
    StudentDao studentDao;
    @RequestMapping("/{id}")
    public Student getstuedent(@PathVariable("id") long id){
        return studentDao.findById(id);
    }
    
    @RequestMapping("/students")
    public List<Student> getstudents(){
        return studentDao.findAll();
    }
    
    @RequestMapping("delete/{id}")
    public void deleteStudent(@PathVariable("id") long id){
        studentDao.deleteById(id);
    }
    
    @RequestMapping("create")
    public Student createStudent(){
        Student student = new Student();
        student.setName("王慕霸");
        student.setUsername("wangmuba");
        student.setQq("123456");
        student.setSchool("温州大学");
        student.setProfession("java");
        if(studentDao.createStudents(student)){
            return studentDao.findOne("name","王慕霸");
        }
        return null;
    }
    
    @RequestMapping("update/{id}")
    public Student updateStudent(@PathVariable("id") long id){
        Student student = studentDao.findById(id);
        System.out.println(student);
        student.setName("王慕霸1");
        student.setUsername("wangmuba1");
        student.setQq("1234561");
        student.setSchool("温州1大学");
        student.setProfession("1java");
        System.out.println(student);
        if(studentDao.updateStudents(student)){
            return studentDao.findById(id);
        }
        return null;
        
    }

}
