package com.jnshu.java.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.jnshu.java.dao.DaoHelper;
import com.jnshu.java.dao.StudentDao;
import com.jnshu.java.model.Student;

@Service
public class StudentsDaoImpl implements StudentDao {

    DaoHelper daoHelper = new DaoHelper();

    public List<Student> findAll() {
        ResultSet resultSet = daoHelper.executeQuery("select * from students");
        return resultSetToList(resultSet);

    }

    public Student findById(long id) {
        ResultSet resultSet = daoHelper.executeQuery(String.format("select * from students where id='%d'", id));
        return resultSetToStudent(resultSet);
    }

    public Student findOne(String property, String name) {
        ResultSet resultSet = daoHelper
                .executeQuery(String.format("select * from students where %s='%s'", property, name));
        return resultSetToStudent(resultSet);
    }

    public boolean deleteAll() {
        return daoHelper.executeUpdata("delete from students");

    }

    public boolean deleteById(long id) {
        return daoHelper.executeUpdata(String.format("delete from students where id='%d'", id));

    }

    public boolean deleteOne(String property, String key) {
        return daoHelper.executeUpdata(String.format("delete from students where %s='%s'", property, key));

    }

    public boolean createStudents(Student s) {
        Date date = new Date();
        long time = date.getTime();
        return daoHelper.executeUpdata(String.format(
                "insert into students(username,name,qq,profession,"
                        + "create_at,update_at,school,student_id,url,declaration,matchmaker) values('%s','%s','%s','%s','%d','%d','%s','%s','%s','%s','%s')",
                s.getUsername(), s.getName(), s.getQq(), s.getProfession(), time, s.getUpdateAt(), s.getSchool(),
                s.getStudentId(), s.getUrl(), s.getDeclaration(), s.getMatchmaker()));

    }

    public boolean updateStudents(Student s) {
        Date date = new Date();
        long time = date.getTime();
        return daoHelper.executeUpdata(String.format(
                "update students set username='%s',name='%s',qq='%s',profession='%s',update_at='%d',school='%s',student_id='%s',url='%s',declaration='%s',matchmaker='%s' where id='%d'",
                s.getUsername(), s.getName(), s.getQq(), s.getProfession(), time, s.getSchool(), s.getStudentId(),
                s.getUrl(), s.getDeclaration(), s.getMatchmaker(), s.getId()));

    }

    public Student resultSetToStudent(ResultSet rs) {
        Student students = new Student();
        try {
            while (rs.next()) {
                students.setId(rs.getInt("id"));
                students.setUsername(rs.getString("username"));
                students.setName(rs.getString("name"));
                students.setQq(rs.getString("qq"));
                students.setStudentId(rs.getString("student_id"));
                students.setDeclaration(rs.getString("declaration"));
                students.setMatchmaker(rs.getString("matchmaker"));
                students.setProfession(rs.getString("profession"));
                students.setUrl(rs.getString("url"));
                students.setSchool(rs.getString("school"));
                return students;
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    public List<Student> resultSetToList(ResultSet rs) {
        List<Student> students = new ArrayList<>();
        try {
            while (rs.next()) {
                Student student = resultSetToStudent(rs);
                if (student != null) {
                    students.add(student);
                }
            }
            return students;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

}
