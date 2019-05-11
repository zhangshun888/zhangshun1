package com.zhangshun.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Driver;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;

public class registerservlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public registerservlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	private String user;
	private String pass;
	
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
				try {
					Class.forName("com.mysql.jdbc.Driver");
					System.out.println("");
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					System.out.println("未成功");
					e.printStackTrace();
				}

				try {

				  user=request.getParameter("user");
					pass=request.getParameter("pass");
					Connection con=(Connection) DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/studb","root","admin");
					System.out.println("");
					 Statement sta=(Statement) con.createStatement();
					int n=sta.executeUpdate("insert studentdb values('"+user+"','"+pass+"')");
					System.out.println("注册成功");
					 
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					System.out.println("注册未成功，已有该用户名");
					e.printStackTrace();
				}
		



	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
