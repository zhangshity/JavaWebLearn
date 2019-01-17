package com.zcy.test;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class LoginServlet implements Servlet {

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
		// TODO Auto-generated method stub

	}

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Http请求来了...");

		// 测试 ServletRequst 接口的实现
		System.out.println(req);

		// =======================获取http request报文中发送的参数值(报文内容)=====================
		System.out.println("=======================获取http request报文中发送的参数值(报文内容)=====================");
		// String getParameter(String name)
		String user = req.getParameter("user");
		String password = req.getParameter("password");
		System.out.println("user: " + user + " password: " + password);
		// 请求参数有多个value,只能获取第一个
		String interesting = req.getParameter("interesting");
		System.out.println("单个getParameter()请求: " + "interesting: " + interesting);

		// 改进
		// String[] getParameterValues(name)
		String[] interestingArray = req.getParameterValues("interesting");
		for (String for_interesting : interestingArray) {
			System.out.println("循环遍历后的interesting -->: " + for_interesting);
		}

		// Enumeration getParameterNames()
		Enumeration<String> names = req.getParameterNames();
		while (names.hasMoreElements()) {
			String name = (String) names.nextElement();
			System.out.println("Enumeration getParameterNames() - name:--> " + name);
		}

		// Map getParameterMap()
		Map<String, String[]> map = req.getParameterMap();
		for (Map.Entry<String, String[]> entry : map.entrySet()) {
			System.out.println("" + entry.getKey() + ":" + Arrays.asList(entry.getValue()));
		}

		// ====================获取URL地址等=====================
		System.out.println("====================获取URL地址等=====================");
		// 获取URL地址 (需要强制转换成子接口 HttpServletRequest)
		HttpServletRequest httpServletRequest = (HttpServletRequest) req;

		String requestURL = httpServletRequest.getRequestURI();
		System.out.println("Url: " + requestURL);

		String requestMethod = httpServletRequest.getMethod();
		System.out.println("Method: " + requestMethod);

		// get方法的 URL请求参数 字符串 (必须method = "get")
		String queryString = httpServletRequest.getQueryString();
		System.out.println("queryString: " + queryString);

		String servletPath = httpServletRequest.getServletPath();
		System.out.println("servletPath: " + servletPath);

		// ========================================================
		// ===================response 返回报文=====================
		System.out.println("================  response 响应 返回报文=====================");
		// 页面打印

		// 设置内容类型
//		res.setContentType("application/msword"); //word文档下载
		PrintWriter printWriter = res.getWriter();
		printWriter.println("Hello,World!");

	}

}
