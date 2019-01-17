package com.zcy.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class LoginServlet2 implements Servlet {

	//静态变量暂存从 servlet 取出的参数值
	private static String UserInServlet = null;
	private static String PasswordInServlet = null;

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("LoginServlet2 init ...");

		// 在 servlet 中定义的参数<init-param>
//		UserInServlet = config.getInitParameter("user");
//		PasswordInServlet = config.getInitParameter("password");
		
		// 在 web 应用中定义的参数<context-param>
		ServletContext servletContext = config.getServletContext();
		UserInServlet = servletContext.getInitParameter("user");
		PasswordInServlet = servletContext.getInitParameter("password");
		
		System.out.println("user: " + UserInServlet + " password: " + PasswordInServlet);

	}

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String requestUser = req.getParameter("user");
		String requestPassword = req.getParameter("password");

		// 定义 browser 返回输出对象
		PrintWriter printWriter = res.getWriter();

		if (UserInServlet.equals(requestUser)) {
			if (PasswordInServlet.equals(requestPassword)) {
				printWriter.print("Login Successful!" + "\n" + "Hello,World!");
			} else {
				printWriter.println("Password do not match!");
			}

		} else {
			printWriter.println("Sorry! This user do not exist!");
		}

	}

}
