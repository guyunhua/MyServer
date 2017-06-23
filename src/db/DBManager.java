package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBManager {
	public static final String DRIVER = "com.mysql.jdbc.Driver";
	public static final String USER = "root";
	public static final String PASS = "root";
	public static final String URL = "jdbc:mysql://localhost:3306/mytestdb";
	
	private static DBManager per = null;
	private Connection conn = null;
	private Statement stmt = null;
	
	private DBManager(){
		
	}
	
	public static DBManager createInstance(){
		if(per == null){
			per = new DBManager();
			per.initDB();
			
		}
		return per;
		
	}
	
	public void initDB(){
		try{
			Class.forName("com.mysql.jdbc.Driver");
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void connectDB(){
		System.out.println("Connecting to database...");
		try{
			conn = DriverManager.getConnection(URL, USER, PASS);
			stmt = conn.createStatement();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		System.out.println("SqlManager:Connect to database successful.");
	}
	
	public void closeDB(){
		System.out.println("Close connection to database...");
		try{
			stmt.close();
			conn.close();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		System.out.println("Close Connection Successful");
	}
	
	public ResultSet executeQuery(String sql){
		ResultSet rs = null;
		try{
			rs = stmt.executeQuery(sql);
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return rs;
		
	}
	
	public int executeUpdate(String sql){
		int ret = 0;
		try{
			ret = stmt.executeUpdate(sql);
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return ret;
	}
}
