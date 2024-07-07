package ece.dept.services;

import java.io.IOException;

import ece.dept.db.ConnectDB;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class studentlogin
 */
public class studentlogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String password;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public studentlogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String studentemail = request.getParameter("email");
	    String password = request.getParameter("password");
	    try {
	        Connection con = ConnectDB.getConnect();
	        PreparedStatement ps = con.prepareStatement("SELECT * FROM Registrationdetails_details WHERE studentemail=? AND password=?");
	        ps.setString(1, studentemail);
	        ps.setString(2, password);
	        ResultSet rs = ps.executeQuery();
	        if (rs.next()) {
	            // If login successful, redirect to Welcomestudent.html
	            response.sendRedirect("Welcomestudent.html");
	        } else {
	            // If login fails, redirect to 404.html
	            response.sendRedirect("404.html");
	        }
	        // Close resources
	        rs.close();
	        ps.close();
	        con.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }}}
