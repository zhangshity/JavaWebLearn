package com.zcy.generic;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyHttpServlet extends MyGenericServlet {

	// 自定义的写法
//	@Override
//	public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
//
//		if (arg0 instanceof HttpServletRequest) {
//			HttpServletRequest httpServletRequest = (HttpServletRequest) arg0;
//
//			if (arg1 instanceof HttpServletResponse) {
//				HttpServletResponse httpServletResponse = (HttpServletResponse) arg1;
//
//				service(httpServletRequest, httpServletResponse);
//			}
//		}
//	}

	// JDK中的写法
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {

		HttpServletRequest request;
		HttpServletResponse response;

		try {
			request = (HttpServletRequest) req;
			response = (HttpServletResponse) res;
		} catch (ClassCastException e) {
			throw new ServletException("non-HTTP request or response");
		}
		service(request, response);
	}

	protected void service(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
			throws ServletException, IOException {
		// 1.获取请求方式
		String method = httpServletRequest.getMethod();

		// 2.根据请求方式再调用对应的处理方法
		if ("GET".equalsIgnoreCase(method)) {
			doGet(httpServletRequest, httpServletResponse);
		} else if ("POST".equalsIgnoreCase(method)) {
			doPost(httpServletRequest, httpServletResponse);
		}

	}

	public void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	public void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
