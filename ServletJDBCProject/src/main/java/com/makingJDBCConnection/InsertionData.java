package com.makingJDBCConnection;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/insertioninfo")
public class InsertionData  extends HttpServlet{
	
	private static final long serialVersionUID = 1L; 
	  
    protected void doPost(HttpServletRequest request,  HttpServletResponse response) throws ServletException, IOException 
    { 
        try { 
  
            // Initialize the database
            Connection con = DBConnection.DBConnectionEstablished(); 
              
            String sqlcode="insert into userinfo values(?, ?)";
           
            PreparedStatement st = con.prepareStatement(sqlcode); 
  
            st.setInt(1, Integer.valueOf(request.getParameter("id"))); 
            st.setString(2, request.getParameter("string")); 
            st.executeUpdate(); 
            st.close(); 
            con.close(); 
  
            PrintWriter out = response.getWriter(); 
            out.println("cool program Executd"); 
        } 
        catch (Exception e) { 
            e.printStackTrace(); 
        } 
    } 
 }
