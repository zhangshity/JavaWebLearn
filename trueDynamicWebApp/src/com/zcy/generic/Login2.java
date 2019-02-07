package com.zcy.generic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Login2 extends MyHttpServlet {

	@Override
	public void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
			throws ServletException, IOException {

		// 0.获取请求方式
		String method = httpServletRequest.getMethod();
		System.out.println(method);

		// 1.获取请求参数
		String requestUser = httpServletRequest.getParameter("user");
		String requestPassword = httpServletRequest.getParameter("password");

		// 2.获取当前 WEB 应用的初始化参数: user password (使用ServletContext对象)

		String initUser = httpServletRequest.getServletContext().getInitParameter("user");
		String initPassword = httpServletRequest.getServletContext().getInitParameter("password");

		// 3.比对打印
		PrintWriter printWriter = httpServletResponse.getWriter(); // 定义 browser 返回输出对象

		if (initUser.equals(requestUser)) {
			if (initPassword.equals(requestPassword)) {
				printWriter.print("Login Successful!" + "\n" + "Hello,World!");
			} else {
				printWriter.println("Password do not match!");
			}

		} else {
			printWriter.println("Sorry! This user do not exist!");
		}
	}
}
