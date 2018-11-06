package org.lanqiao.controller;

import org.lanqiao.pojo.student;
import org.lanqiao.service.impl.studentServiceImpl;
import org.lanqiao.service.studentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/studentServlet")
public class studentServlet extends HttpServlet {

    studentService studentServlet = new studentServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*
            1、如何使一个Servlet处理多个请求
            2、如何在发送一个get/post请求后，执行某个方法？
            3、接收到请求后Servlet处理哪个请求呢？在请求中添加参数
        */
        /*if (method.equals("queryAllStu")){
            queryAllStu(request, response);
        }else if(method.equals("deleteStu")){
            deleteStu(request, response);
        }*/
        String  method = request.getParameter("method");
        switch (method){
            case "queryAllStu":
                queryAllStu(request, response);
                break;
            case "deleteStu":
                deleteStu(request, response);
                break;
            case "findOneStu" :
                findOneStu(request, response);
                break;
            case "updateStu":
                updateStu(request, response);
                break;
        }
    }

    //查询所有学生的信息
    public void queryAllStu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<student> studentList =  studentServlet.getAllStu();
        request.setAttribute("studentList",studentList);
        request.getRequestDispatcher("/studentList.jsp").forward(request,response);
    }

    //删除一条学生信息
    public void deleteStu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取jsp页面传递的参数
        String sid = request.getParameter("sid");
        //将(String类型的)id转为int类型
        int id = Integer.valueOf(sid);
        //执行操作
        studentServlet.deleteStu(id);
        queryAllStu(request, response);
    }

    //查询一条学生信息
    public void findOneStu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String sid = request.getParameter("sid");
        int id = Integer.valueOf(sid);
        //执行操作,获取一条学生信息
        student student =studentServlet.findOneStu(id);
        //将学生信息放到request中
        request.setAttribute("student",student);
        //将request(请求)转发到updateStu.jsp中
        request.getRequestDispatcher("/updateStu.jsp").forward(request,response);
    }

    //更新学生信息
    public void updateStu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        String sid = request.getParameter("sid");
        int id = Integer.valueOf(sid);
        String name = request.getParameter("sname");
        name = new String(name.getBytes("iso-8859-1"),"utf-8");
        String sage = request.getParameter("sage");
        int age = Integer.valueOf(sage);
        String province = request.getParameter("sprovince");
        province =new String(province.getBytes("iso-8859-1"),"utf-8");
        String stuition = request.getParameter("stuition");
        int tuition = Integer.valueOf(stuition);
        student student = new student(id,name,age,province, tuition);
        studentServlet.updateStu(student);
        System.out.println(student);
        queryAllStu(request, response);


    }
}
