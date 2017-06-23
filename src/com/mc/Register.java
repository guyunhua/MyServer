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
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private String name;
	private String pass;
	private String confirm;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);  
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		
		this.name = request.getParameter("username");
		this.pass = request.getParameter("password");
		//this.confirm = request.getParameter("confirm");
		
		Service serv = new Service();
		boolean register = serv.register(name, pass);
		if(register){
			System.out.print("Success");
			request.getSession().setAttribute("username", name);
			out.print("Success ");
		}
		else{
			System.out.print("Failed");
			out.print("Failed ");
		}
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		
		out.print("”√ªß√˚£∫" + name );
		out.print("√‹¬Î£∫" + pass);
		out.flush();
		out.close();
		
	}

}
