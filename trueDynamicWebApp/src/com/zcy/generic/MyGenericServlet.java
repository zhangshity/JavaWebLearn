package com.zcy.generic;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/*
 * 自定义的Servlet接口的 实现类 MyGenericServlet
 *       目的: 1)任何开发的Servlet 都继承此类,简化开发
 * 
 * @Author: Chunyang Zhang
 * */
public abstract class MyGenericServlet implements Servlet, ServletConfig {

	// ===============Servlet 接口的实现方法====================================
	@Override
	public void destroy() {
	}

	// 自定义返回 ServletConfig对象
	@Override
	public ServletConfig getServletConfig() {
		return servletConfig;
	}

	@Override
	public String getServletInfo() {
		return null;
	}

	// 自定义 ServletConfig 对象
	private ServletConfig servletConfig;

	// init() 参数ServletConfig对象 等于成员变量servletConfig对象
	@Override
	public void init(ServletConfig arg0) throws ServletException {
		this.servletConfig = arg0;
		this.init();
	}

	// 自动以空init()方法重写,用于继承方法的init()方法的重写
	public void init() throws ServletException {
	}

	@Override
	public abstract void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException;

	// ==============================================================================

	// ===============ServletConfig 接口的实现方法====================================
	@Override
	public String getInitParameter(String name) {
		return servletConfig.getInitParameter(name);
	}

	@Override
	public Enumeration<String> getInitParameterNames() {
		return servletConfig.getInitParameterNames();
	}

	@Override
	public ServletContext getServletContext() {
		return servletConfig.getServletContext();
	}

	@Override
	public String getServletName() {
		return servletConfig.getServletName();
	}

}
