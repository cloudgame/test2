package com.lzq.model;
import java.sql.*;

public class SqlHelper {
	
	//���ݿ�������
	static String deriver="com.mysql.jdbc.Driver";
	//URLָ���Ҫ���ʵ����ݿ���userinfo
	static String url="jdbc:mysql://127.0.0.1:3306/userinfo";
	//mysql����ʱ���û���
	static String username="root";
	//mysql����ʱ������
	static String password="123456";
	static Connection ct=null;
	static PreparedStatement ps=null;
	static ResultSet rs=null;
	
	static
	{
		try {
			Class.forName(deriver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//��������
	public void connection()
	{
		//��������
		try {
			ct=DriverManager.getConnection(url,username,password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("�������ݿ�ɹ���");
	}
	
	//�����ݿ�ִ�С�������ɾ�����ġ�
		public boolean updateSql(String sql,String[] para)
		{
			boolean b=false;
			try {
				connection();
				//����ps,Ԥ������ٴ��͵����ݿ���
				ps=ct.prepareStatement(sql);
				//�鿴����
				for(int j=0;j<para.length;j++)
				{
					System.out.println("para["+j+"]="+para[j]);
				}
				//��ps����ʺŽ��и�ֵ
				for(int i = 0;i<para.length;i++)
				{
					ps.setString(i+1, para[i]);
				}
				//ִ�С�������ɾ�����ġ�����
				ps.executeUpdate();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return b;
		}
	
	//�����ݿ�ִ��"����"
	public ResultSet query(String sql,String[] para)
	{
		try {
			connection();
			ps=ct.prepareStatement(sql);
			for(int i = 0;i<para.length;i++)
			{
				ps.setString(i+1, para[i]);
			}
			rs=ps.executeQuery();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			return rs;
		}
	}
	
	//�ر���Դ
	public void close(ResultSet rs,PreparedStatement ps,Connection ct)
	{
		try {
			if(rs!=null)
			{
				rs.close();
			}
			rs=null;
			if(ps!=null)
			{
				ps.close();
			}
			ps=null;
			if(ct!=null)
			{
				ct.close();
			}
			ct=null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
