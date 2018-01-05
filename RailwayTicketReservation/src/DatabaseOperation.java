

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DatabaseOperation {
	private Connection c = null;
	private Statement stmt = null;
	
	public void connectDb() throws Exception{
		
	      //try {
	         Class.forName("org.postgresql.Driver");
	         c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/deneme","postgres", "05081989");
	      /*} catch (Exception e) {
	         e.printStackTrace();
	         System.err.println(e.getClass().getName()+": "+e.getMessage());
	         System.exit(0);
	      }*/
	      System.out.println("Opened database successfully");
	}
	
	public void insertUser(String email,String password,String nationality,String ssn,String passport,String name,
			String surname,String mobile,boolean female,boolean male,String birthday){
		
		String sql ="";
		try {
			connectDb();
			stmt = c.createStatement();
			if(male){
				 sql = "INSERT INTO WEB_USER (NAME,SURNAME,GENDER,EMAIL,PASSWORD,NATIONALITY,MOBILE,SSN,PASSPORT,BIRTHDAY) "
						+ "VALUES ('" + name + "', '"+ surname + "', 'ERKEK', '" + email + "', '" + password + "', '" + nationality +
						"', '" + mobile + "', '" + ssn + "', '" + passport + "', '" + birthday + "');";
			}
			else if(female){
				sql = "INSERT INTO WEB_USER (NAME,SURNAME,GENDER,EMAIL,PASSWORD,NATIONALITY,MOBILE,SSN,PASSPORT,BIRTHDAY) "
						+ "VALUES ('" + name + "', '"+ surname + "', 'KADIN', '" + email + "', '" + password + "', '" + nationality +
						"', '" + mobile + "', '" + ssn + "', '" + passport + "', '" + birthday + "');";
	        }
			stmt.executeUpdate(sql);
			stmt.close();
			c.close();
		} catch (Exception e) {
			e.printStackTrace();
	         System.err.println(e.getClass().getName()+": "+e.getMessage());
	         System.exit(0);
		}
	}
	
	public String validateUser(String email,String password){
		String control = "";
		String sql ="";
		try {
			connectDb();
			stmt = c.createStatement();
			if(password.equals("duplicate"))
				sql = "SELECT * FROM WEB_USER WHERE EMAIL='" + email + "'";
			else
				sql = "SELECT * FROM WEB_USER WHERE EMAIL='" + email + "' AND PASSWORD='" + password + "'";
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next())
				control = rs.getString("name") + " " + rs.getString("surname");
		}catch (Exception e) {
			e.printStackTrace();
	         System.err.println(e.getClass().getName()+": "+e.getMessage());
	         System.exit(0);
		}
		return control;
	}
}
