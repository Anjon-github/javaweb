package com.xhm.web.database;

import com.xhm.web.bean.Student;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentBusiness {

    public static List<Student> getAllStudents(){
        List<Student> list = new ArrayList<>();
        DBHelper dbHelper = new DBHelper();
        try {
            ResultSet rs = dbHelper.stmt.executeQuery("select * from student");
            while(rs.next()){
                Student student = new Student();
                student.setId(rs.getInt(1));
                student.setName(rs.getString(2));
                student.setAge(rs.getInt(3));
                student.setMobile(rs.getInt(4));
                student.setSex(rs.getInt(5));

                list.add(student);
            }
            rs.close();
            dbHelper.close();
        }catch (SQLException e){
            e.printStackTrace();
        }

        return list;
    }
}
