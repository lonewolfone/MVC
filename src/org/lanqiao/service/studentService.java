package org.lanqiao.service;

import org.lanqiao.pojo.student;

import java.util.List;

public interface studentService {
    //查询所有学生信息
    public List<student> getAllStu();
    //删除学生信息
    public void deleteStu(int id);
    //查询一条学生信息
    public student findOneStu(int id);
    //更新学生信息
    public void updateStu(student student);
}
