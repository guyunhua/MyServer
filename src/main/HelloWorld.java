package main;

import java.io.IOException;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

/**
 * Servlet implementation class HelloWorld
 */
@WebServlet("/HelloWorld")
public class HelloWorld extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HelloWorld() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 String driverName = "com.mysql.jdbc.Driver";  //����JDBC����
		  String dbURL = "jdbc:mysql://localhost:3306/mytestdb";  //���ӷ����������ݿ�sample
		  String userName = "root";  //Ĭ���û���
		  String userPwd = "root";  //����
		  Connection dbConn;
		  try {
		   Class.forName(driverName);
		   dbConn = (Connection) DriverManager.getConnection(dbURL, userName, userPwd);
		   System.out.println("Connection Successful!");  //������ӳɹ� ����̨���Connection Successful!
		   Statement state = (Statement) dbConn.createStatement();
		   String sql="select * from users";
		   state.executeQuery(sql);
		  } catch (Exception e) {
		   e.printStackTrace();
		  }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
