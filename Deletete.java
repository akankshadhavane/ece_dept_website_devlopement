package ece.dept.services;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ece.dept.db.ConnectDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 * Servlet implementation class Deletete
 */
public class Deletete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Deletete() {
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
		doGet(request, response);
		String rollnumber = request.getParameter("rollnumber");

		try {
		    Connection con = ConnectDB.getConnect();
		    
		    PreparedStatement ps = con.prepareStatement("DELETE FROM te_details WHERE rollnumber = ?");
		    ps.setString(1, rollnumber);
		    
		    int i = ps.executeUpdate();
		    
		    if (i > 0) {
		        response.sendRedirect("TEclass.html");
		    } else {
		        response.sendRedirect("404.html");
		    }
		} catch (Exception e) {
		    e.printStackTrace();
		}

	}

}
