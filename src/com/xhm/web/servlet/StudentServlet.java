package com.xhm.web.servlet;

import com.xhm.web.bean.ListObject;
import com.xhm.web.bean.Student;
import com.xhm.web.bean.status.StatusHouse;
import com.xhm.web.database.StudentBusiness;
import com.xhm.web.utils.JackJsonUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class StudentServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Student> list = StudentBusiness.getAllStudents();
        ListObject listObject = new ListObject();
        listObject.setItems(list);
        listObject.setStatusObject(StatusHouse.COMMON_STATUS_OK);
        String rspJson = JackJsonUtils.toJson(listObject);
        String userAgent = request.getHeader("User-Agent");

        System.out.println("reqIp：" + request.getRemoteHost() + " userAgent："  + userAgent + " rspData " + rspJson);

        response.setContentType("text/plain;charset=UTF-8");
        response.setCharacterEncoding("utf-8");
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        response.getWriter().println(rspJson);
    }
}
