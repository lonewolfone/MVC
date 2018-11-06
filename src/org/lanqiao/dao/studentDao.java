package org.lanqiao.dao;

import org.lanqiao.pojo.student;

import java.sql.SQLException;
import java.util.List;

public interface studentDao {
    //查询所有学生信息
    public List<student> findAllStu() throws SQLException;
    //删除学生信息
    public void deleteStu(int id) throws SQLException;
    //查询一条学生信息
    public student findOneStu(int id) throws SQLException;
    //更新学生信息
    public void  updateStu(student student) throws SQLException;
    //添加一条数据
    public void addStu(student student) throws SQLException;

}
