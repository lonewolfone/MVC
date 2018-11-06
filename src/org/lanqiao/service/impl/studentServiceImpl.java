package org.lanqiao.service.impl;

import org.lanqiao.dao.impl.studentDaoImpl;
import org.lanqiao.dao.studentDao;
import org.lanqiao.pojo.student;
import org.lanqiao.service.studentService;

import java.sql.SQLException;
import java.util.List;

public class studentServiceImpl implements studentService {
    studentDao studentDao = new studentDaoImpl();

    @Override
    //查询所有学生信息
    public List<student> getAllStu() {
        List<student> studentList = null;
        try {
            studentList = studentDao.findAllStu();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return studentList;
    }


    @Override
    //删除学生信息
    public void deleteStu(int id) {
        try {
            studentDao.deleteStu(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public student findOneStu(int id) {
        student student = null;
        try {
            student = studentDao.findOneStu(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return student;
    }

    @Override
    public void updateStu(student student) {
        try {
            studentDao.updateStu(student);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
