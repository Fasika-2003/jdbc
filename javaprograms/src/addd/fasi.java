package addd;

import java.util.*;
import java.sql.*;
public class fasi{
	public static void main(String[] args)throws SQLException {
		PreparedStatement st=null;
		Connection con=null;
		Scanner sc=new Scanner(System.in);
		System.out.println("enter the book number");
		int bno=sc.nextInt();
		System.out.println("enter the book name");
		String bname=sc.next();
		System.out.println("enter the book price");
		int price=sc.nextInt();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/booking","root","root");
			con.setAutoCommit(false);
			st = con.prepareStatement("insert into " + "bkstore values(" + bno + ",'" + bname + "'," + price + ")");

			 st.executeUpdate();
			 System.out.println("inserted");
			 con.commit();
		}
		catch(Exception e) {
			con.rollback();
			System.out.println(e);
			
		}finally {
			st.close();
			con.close();
		}
		
	}
}