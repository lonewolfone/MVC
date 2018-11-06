package org.lanqiao.test;

import org.junit.Test;
import org.lanqiao.dao.impl.studentDaoImpl;
import org.lanqiao.dao.studentDao;
import org.lanqiao.pojo.student;
import org.lanqiao.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class test {

    studentDao studentDao = new studentDaoImpl();

    @Test
    //获取链接的测试
    public void  jdbcUtilsTest() throws SQLException {
     Connection connection = JDBCUtils.getConnection();
        System.out.println("======================="+ connection);
    }

    @Test
    //查询所有学生的信息
    public void findAllStuTest() throws SQLException {
        List<student>  studentList = studentDao.findAllStu();
        for (student str:studentList){
            System.out.println(str);
        }
    }

    @Test
    //删除学生信息
    public void deleteStuTest() throws SQLException {
        studentDao.deleteStu(7);
        List<student>  studentList = studentDao.findAllStu();
        for (student str:studentList){
            System.out.println(str);
        }
    }

    @Test
    //查询一条学生信息
    public void findOneStuTest() throws SQLException {
      student student =  studentDao.findOneStu(1);
        System.out.println(student);

    }

    @Test
    //更新
    public  void updateStuTest() throws SQLException {
        student student1 = new student(3,"二狗",23,"山西",23);
        studentDao.equals(student1);
        System.out.println(student1);
    }

    @Test
    //添加
    public void addStuTest() throws SQLException {
        student student = new student("二狗",23,"山西",34);
        studentDao.addStu(student);
    }
}
