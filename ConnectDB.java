package ece.dept.db;
import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectDB 
{
	static Connection con = null;
	public static Connection getConnect()
	{
		try
		{
			if(con==null)
			{
				Class.forName("com.mysql.jdbc.Driver");
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ece_dept_db","root","");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return con;
	}
}
