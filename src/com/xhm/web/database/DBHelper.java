package com.xhm.web.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBHelper {

    public static final String URL = "jdbc:mysql://localhost:3306";
    public static final String NAME = "com.mysql.jdbc.Driver";
    public static final String USER = "root";
    public static final String PASSWORD = "root";

    public Connection conn = null;
    public Statement stmt = null;

    public DBHelper(){
        try{
            Class.forName(NAME);
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            stmt = conn.createStatement();
            stmt.execute("use students_manage");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void close(){
        try {
            conn.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
//        DBHelper dbHelper = new DBHelper();
//        try {
//            dbHelper.queryStudents();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        dbHelper.close();
    }

}
