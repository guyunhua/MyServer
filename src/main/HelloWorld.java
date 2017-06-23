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
		 String driverName = "com.mysql.jdbc.Driver";  //加载JDBC驱动
		  String dbURL = "jdbc:mysql://localhost:3306/mytestdb";  //连接服务器和数据库sample
		  String userName = "root";  //默认用户名
		  String userPwd = "root";  //密码
		  Connection dbConn;
		  try {
		   Class.forName(driverName);
		   dbConn = (Connection) DriverManager.getConnection(dbURL, userName, userPwd);
		   System.out.println("Connection Successful!");  //如果连接成功 控制台输出Connection Successful!
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
