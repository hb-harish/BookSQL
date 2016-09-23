import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Book {

	Scanner sc = new Scanner(System.in);
	Connection con = null;
	Statement stmt = null;
	ResultSet rs = null;
	PreparedStatement pstmt = null;
	String n = "";
	String s = "";
	public void Book()
	{
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
	        con = DriverManager.getConnection("jdbc:oracle:thin:ora1/ora1@localhost:1521:orcl");
			stmt = con.createStatement();
		}catch (SQLException e) 
			{
				e.printStackTrace();
			}catch (ClassNotFoundException e) 
			{
					e.printStackTrace();
			}
	}
	
	public void AddBook(String S)
	{
		pstmt = con.prepareStatement("Update books set sku = ?, title = ?, author = ?, description = ? price = ?");
		
		
	}
	public String GetBook(String S)
	{
		try 
		{
			pstmt = con.prepareStatement(s);
		} 
		catch (SQLException e2) 
		{
			e2.printStackTrace();
		}
		String sku = "";
		rs = pstmt.executeQuery();
		ResultSetMetaData rsmd = rs.getMetaData();
		String c ="";
		int nc = rsmd.getColumnCount();
		c = rsmd.getColumnName(1);
		for (int i =2; i<=nc; i++)
		{
			c = String.format("%s\t%s",c,rsmd.getColumnName(i));
			
		}
		c = String.format("%s\n",c);
		System.out.print(c);
		int j =1;
		String res ="";
		while(rs.next())
		{
			res ="";
			for (int i =1; i<=nc; i++)
			{
				if (i==1) sku =rs.getString(i);
				res += rs.getString(i) + '\t';
				
				
				
			}
			res +="\n";
			System.out.print(res);
			return res;
			
		}
	}
	public void ModBook()
	{
		
	}
	public void DelBook()
	{
		
	}
	
	}
	
	
	

}
