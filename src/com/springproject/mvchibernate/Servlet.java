package com.springproject.mvchibernate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

//@WebServlet("/Servlet")
public class Servlet extends javax.servlet.http.HttpServlet {
//    private static final long serialVersionUID= 1l;
////    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
////
////    }
//
//    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
//        String url="jdbc:mysql://localhost:3306/web_customer_tracker?useSSL=false";
//        String jdbc= "com.mysql.jdbc.Driver";
//        String userName= "springstudent";
//        String passcode= "springstudent";
//
//        try{
//            PrintWriter printWriter= response.getWriter();
//            Class.forName(jdbc);
//            printWriter.println("connecting to database..."+ url);
//            Connection connection= DriverManager.getConnection(url,userName,passcode);
//            printWriter.println("SUCCESS");
//        }catch(Exception e){
//            e.printStackTrace();
//            throw new ServletException();
//        }
//    }
}
