package com.mc;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.service.Service;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		
		String username = request.getParameter("username");
		//username = new String(username.getBytes("ISO-8859-1"), "UTF-8");
		String password = request.getParameter("password");
		if(username == null || password == null){
			out.print("用户名密码不能为空");
			System.out.println("用户名密码不能为空");
			return;
		}
		System.out.println(username + "--" + password);
		
		Service serv = new Service();
		boolean loged = serv.login(username, password);
		if(loged){
			System.out.print("Success");
			out.print("Success ");
			request.getSession().setAttribute("username", username);
		}
		else{
			out.print("Failed ");
			System.out.print("Failed");
		}
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		
		out.print("�û�����" + username );
		out.print("���룺" + password);
		out.flush();
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
