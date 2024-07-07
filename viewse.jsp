<%@page import="java.sql.*" %>
<%@page import="ece.dept.db.ConnectDB" %>



<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<html>
<head>

    
    <title>Student Details</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
        }
        .container {
            max-width: 9000px;
            margin: 200px auto;
            padding: 20px;
            background-color: #fff;
            border-radius: 8px;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
        }
        table {
            width: 150%;
            border-collapse: collapse;
            border: 1px solid #ddd;
        }
        th, td {
            padding: 12px;
            text-align: left;
            border-bottom: 1px solid #ddd;
            border-right: 1px solid #ddd;
        }
        th {
            background-color: #4CAF50;
            color: white;
        }
        tr:last-child td {
            border-bottom: none;
        }
        tr:hover {
            background-color: #f0f0f0;
        }
        .search-container {
            margin-bottom: 20px;
        }
        .search-container input[type=text] {
            padding: 10px;
            font-size: 16px;
            border: 1px solid #ccc;
            border-radius: 4px;
        }
    </style>
</head>
<body>
    <div class="container">
    <h1 style="text-align: center; color: #4CAF50;">Student Details</h1>
    <div class="search-container">
        <input type="text" id="searchInput" onkeyup="filterTable()" placeholder="Search for names...">
    </div>

    <table id="studentTable">
         <tr>
           <th>Name</th>
           <th>Sclass</th>
           <th>Address</th>
           <th>Cast</th> 
           <th>Subclass</th> 
           <th>Category</th> 
           <th>Mobile</th> 
           <th>Parentmobile</th> 
           <th>Studentemail</th> 
           <th>Birthdate</th> 
           <th>Admission Year</th> 
           <th>Admission Type</th> 
           <th>RollNumber</th> 
           <th>Bank Name</th> 
           <th>ifccode</th> 
           <th>Account Number</th> 
         </tr>
         
           <%
              try{
            	  Connection con =ConnectDB.getConnect();
            	  PreparedStatement ps = con.prepareStatement("select * from te_details");
            	  ResultSet rs = ps.executeQuery();
            	  while(rs.next())
            	  {
           %>
            		  <tr>
            		    <td><%=rs.getString(1)%></td>
            		    <td><%=rs.getString(2)%></td>
            		    <td><%=rs.getString(3)%></td>
            		    <td><%=rs.getString(4)%></td>
            		    <td><%=rs.getString(5)%></td>
            		    <td><%=rs.getString(6)%></td>
            		    <td><%=rs.getString(7)%></td>
            		    <td><%=rs.getString(8)%></td>
            		    <td><%=rs.getString(9)%></td>
            		    <td><%=rs.getString(10)%></td>
            		    <td><%=rs.getString(11)%></td>
            		    <td><%=rs.getString(12)%></td>
            		    <td><%=rs.getString(13)%></td>
            		    <td><%=rs.getString(14)%></td>
            		    <td><%=rs.getString(15)%></td>
            		    <td><%=rs.getString(16)%></td>
            		    
            		    
            		   </tr>
            <% 
            		  
            	  }
              }
             catch(Exception e)
           {
            	  e.printStackTrace();
           }
           
           %>
              
           
          
        
        </table>




 <script>
        function filterTable() {
            var input, filter, table, tr, td, i, txtValue;
            input = document.getElementById("searchInput");
            filter = input.value.toUpperCase();
            table = document.getElementById("studentTable");
            tr = table.getElementsByTagName("tr");
            for (i = 0; i < tr.length; i++) {
                td = tr[i].getElementsByTagName("td")[0]; // Change index if you want to search in other columns
                if (td) {
                    txtValue = td.textContent || td.innerText;
                    if (txtValue.toUpperCase().indexOf(filter) > -1) {
                        tr[i].style.display = "";
                    } else {
                        tr[i].style.display = "none";
                    }
                }       
            }
        }
    </script>

</body>
</html>