package com.lzq.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserLogin extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<HTML>");
		out.println("<h1>�û���¼</h1>");
		out.println("<img src=\"/img/test4.jpg\"/>");
		out.println("<form action=/UserManager/LoginYZ method='post'>");
		out.println("�û�����<input type='text' name='username'/></br>");
		out.println("��    �룺<input type='password' name='password'/></br>");
		out.println("<input type='submit' value='��¼'/></br>");
		out.println("</form>");
		String errInfo=(String) request.getAttribute("err");
		if(errInfo!=null)
		{
			out.println("<font color='red'>"+errInfo+"</font>");
		}
		out.println("</HTML>");
		out.flush();
		out.close();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

}
