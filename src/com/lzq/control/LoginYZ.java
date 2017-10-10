package com.lzq.control;

import com.lzq.model.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginYZ extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		//��ȡ���û���������
		int userId=Integer.parseInt(request.getParameter("username"));
		String passwd=request.getParameter("password");
		//���û������붨�嵽UserLogin��
		UserLoginInfo ul=new UserLoginInfo();
		ul.setId(userId);
		ul.setPsw(passwd);
		//��֤�û����������Ƿ���ȷ
		UserService uv=new UserService();
		boolean b=uv.checkUser(ul);
		if(b)
		{
			//�����֤ͨ��
			request.getRequestDispatcher("/MainFrame").forward(request, response);
		}
		else
		{
			//�����֤ʧ��
			request.setAttribute("err","�û�������������");
			request.getRequestDispatcher("/UserLogin").forward(request, response);
		}
		
		
		/*
		 * 
		 * 
		//���ݿ�������
		String deriver="com.mysql.jdbc.Driver";
		//URLָ���Ҫ���ʵ����ݿ���userinfo
		String url="jdbc:mysql://127.0.0.1:3306/userinfo";
		//mysql����ʱ���û���
		String username="root";
		//mysql����ʱ������
		String password="123456";
		Connection ct=null;
		ResultSet rs=null;
		PreparedStatement ps=null;
		
		try {
			//1.��������
			Class.forName(deriver);
			try {
				//2.�õ�����
				ct=DriverManager.getConnection(url,username,password);
				System.out.println("���ݿ���֤�ɹ���");
				//3.����PreparedStatement
				ps=ct.prepareStatement("select * from userlogin where id=? and pwd=?");
				//������ֵ
				ps.setObject(1, userId);
				ps.setObject(2, passwd);
				//4.ִ�в���
				rs=ps.executeQuery();
				//5.���ݽ������
				if(rs.next())
				{
					request.getRequestDispatcher("/MainFrame").forward(request, response);
				}
				else
				{
					request.setAttribute("err","�û�������������");
					request.getRequestDispatcher("/UserLogin").forward(request, response);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			if(rs!=null)
			{
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				rs=null;
			}
			if(ps!=null)
			{
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				ps=null;
			}
			if(ct!=null)
			{
				try {
					ct.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				ct=null;
			}
		}
		
		*/
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

}
