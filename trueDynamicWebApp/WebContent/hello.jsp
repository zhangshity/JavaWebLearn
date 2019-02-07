<%@page import="java.util.Date"%>
<%@page import="com.zcy.test.Person"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		Person person = new Person();
		System.out.println(person.getPerson());
	%>

	<!-- JSP 学习开始 -->
	<%
		Date date = new Date();
		System.out.println("-->" + date);
	%>

	<%
		//date 指显式对象,需要声明才能用
		String s = date.toString();
		//没有声明就可以调用的对象引用为 隐式对象 (共9个)
		//request、response 、pageContext、session、application、config、out、page、exception

		//1) request   HttpServletRequest对象的一个引用
		String name = request.getParameter("name");
		System.out.println(name);

		//2) response   HttpServletResponse对象的一个引用
		Class clazz = response.getClass();
		System.out.println(clazz + "\n" + (response instanceof HttpServletResponse));

		//3) pageContext   页面上下文,PageContext对象的引用(从中可以获取其他8个隐藏对象,也可以获取页面信息)
		ServletRequest req = pageContext.getRequest();
		System.out.println(req == request);
		
		//4) session   游览器和服务器的一次对话 HttpSession对象的引用



	%>

</body>
</html>