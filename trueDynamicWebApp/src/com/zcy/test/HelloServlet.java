package com.zcy.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class HelloServlet implements Servlet {

	// 构造函数constructor
	public HelloServlet() {
		// TODO Auto-generated constructor stub
		System.out.println("HelloServlet constructor....");
	}

	// destory()
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("destory...");

	}

	// Config
	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		System.out.println("getServletConfig....");
		return null;
	}

	// Info
	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		System.out.println("getServletInfo...");
		return null;
	}

	// init()
	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("init...");

		// ~~~~~~~~~~~分割===获取servlet初始化参数名称<init-value>=============================================================
		System.out.println("\n" + "======获取servlet初始化参数名称<init-value>============");

		// 获取servlet初始化参数名称<init-value> ~参数值-getInitParameter()
		String user = config.getInitParameter("user");
		System.out.println("user: " + user);

		// 获取servlet初始化参数名称<init-name> 返回的是Enumeration值 ~参数名-getInitParameterNames()
		Enumeration<String> names = config.getInitParameterNames();
		while (names.hasMoreElements()) {
			String name = (String) names.nextElement();
			String value = config.getInitParameter(name);
			System.out.println("name: " + name + " value: " + value);
		}

		// 获取servletName ~Servlet名称-getServletName()
		String serletname = config.getServletName();
		System.out.println(serletname);

		// ~~~~~~~~~~~分割===servletContext=============================================================
		System.out.println("\n" + "======获取servletContext 对象============");
		// 获取servletContext 对象
		ServletContext servletContext = config.getServletContext();
		String driver = servletContext.getInitParameter("driver");
		String jdbcUrl = servletContext.getInitParameter("jdbcUrl");
		System.out.println("ServletContext: " + driver + "|" + jdbcUrl);

		Enumeration<String> names2 = servletContext.getInitParameterNames();
		while (names2.hasMoreElements()) {
			String name = (String) names2.nextElement();
			String driverByName = servletContext.getInitParameter(name);
			System.out.println("name: " + name + "value: " + driverByName);
		}

		// =========获取文件绝对路径(服务器)=========================================================
		String realPath = servletContext.getRealPath("/note.txt");
		System.out.println("Path: " + realPath);

		// 获取项目名称
		String contextPath = servletContext.getContextPath();
		System.out.println(contextPath);

		// 当前web项目 某一个文件对应的输入流输出流
		try {
			// 1) ClassLoader 获取
			ClassLoader classLoader = getClass().getClassLoader();
			InputStream inputStream = classLoader.getResourceAsStream("jdbc.properties");
			System.out.println("1 ." + inputStream);

			// 2) ServletContext 获取
			InputStream inputStream2 = servletContext.getResourceAsStream("/WEB-INF/classes/jdbc.properties");
			System.out.println("2. " + inputStream2);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// service()
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("service...");
	}

}
