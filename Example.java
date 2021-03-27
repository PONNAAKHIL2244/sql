package dbconnection;

import java.sql.*;

public class Example {
public static void main(String args[])
{ 
	StudentDao dao=new StudentDao();
	Student s1=dao.getstudent(1);
	System.out.println(s1.sname);
}
}
class StudentDao
{
	public Student getstudent(int id)
	{
		try {
			
		
		Student s =new Student();
		s.id=id;
		Class.forName("com.mysql.jdbc.Driver");
		 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/database","root","15036244");
		 Statement st=con.createStatement();
		 ResultSet rs=st.executeQuery("select sname from student where id="+id);
		rs.next();
		String name=rs.getString(1);
		 s.sname=name;
		return s;
	    } catch (Exception e)
		{
		System.out.println(e);
		}
		return null;
     }
}
class Student
{
	int id;
	String sname;
}