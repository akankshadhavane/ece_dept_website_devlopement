package ece.dept.services;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ece.dept.db.ConnectDB;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Servlet implementation class AddSEstudent
 */
public class AddSEstudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddSEstudent() {
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
		String name = request.getParameter("name");
		String sclass = request.getParameter("sclass");
		String address = request.getParameter("address");
		String cast = request.getParameter("cast");
		String subcast = request.getParameter("subcast");
		String category = request.getParameter("category");
		String mobile = request.getParameter("mobile");
		String parentsmobile = request.getParameter("parentsmobile");
		String studentemail = request.getParameter("studentemail");
		String birthdate= request.getParameter("birthdate");
		String admissionyear = request.getParameter("admissionyear");
		String admissiontype = request.getParameter("admissiontype");
		String rollnumber = request.getParameter("rollnumber");
		String bankname = request.getParameter("bankname");
		String ifccode = request.getParameter("ifccode");
		String accountnumber = request.getParameter("accountnumber");
		String password = request.getParameter("password");
		

		try
		{
			Connection con = ConnectDB.getConnect();
			PreparedStatement ps = con.prepareStatement("insert into se_details values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			ps.setString(1, name);
			ps.setString(2, sclass);
			ps.setString(3, address);
			ps.setString(4, cast);
			ps.setString(5, subcast);
			ps.setString(6, category);
			ps.setString(7, mobile);
			ps.setString(8, parentsmobile);
			ps.setString(9, studentemail);
			ps.setString(10, birthdate);
			ps.setString(11, admissionyear);
			ps.setString(12, admissiontype);
			ps.setString(13, rollnumber);
			ps.setString(14, bankname);
			ps.setString(15, ifccode);
			ps.setString(16, accountnumber);
			ps.setString(17, password);
			
			int i = ps.executeUpdate();
			if(i>0)
			{
				response.sendRedirect("index.html");
			}
			else
			{
				response.sendRedirect("404.html");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
