package org.lanqiao.dao.impl;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.lanqiao.dao.studentDao;
import org.lanqiao.pojo.student;
import org.lanqiao.utils.JDBCUtils;

import java.sql.SQLException;
import java.util.List;

public class studentDaoImpl implements studentDao {

    //创建queryRunner对象
    QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());

    @Override
    //查询所有学生信息
    public List<student> findAllStu() throws SQLException {
        List<student> studentList = null;
        String sql = "select * from student";
        studentList = queryRunner.query(sql,new BeanListHandler<>(student.class));
        return studentList;
    }

    @Override
    //删除学生信息
    public void deleteStu(int id) throws SQLException {
        String sql = "delete  from student where sid = ?";
        queryRunner.update(sql,id);
    }

    @Override
    //查询一条学生信息
    public student findOneStu(int id) throws SQLException {
        student student = null;
        String sql = "select * from student where sid = ?";
        student = queryRunner.query(sql,new BeanHandler<>(student.class),id);
        return student;
    }

    @Override
    //更新
    public void updateStu(student student) throws SQLException {
        String sql = "update student set sname=? ,sage =? ,sprovince=?,stuition=? where sid=?";
        queryRunner.execute(sql,student.getSid(),student.getSname(),student.getSage(),student.getSprovince(),student.getSprovince());
    }

    @Override
    //添加一条数据
    public void addStu(student student) throws SQLException {
        String sql = "insert into student(sid,sname,sage,sprovince,stuition) values(?,?,?,?,?)";
        queryRunner.update(sql,student.getSid(),student.getSname(),student.getSage(),student.getSprovince(),student.getStuition());
    }
}
