package com.lzq.model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserService {

	//��ȡ�û���Ϣ
	
	//��֤�û��Ƿ���ȷ
	public boolean checkUser(UserLoginInfo ul)
	{
		boolean b=false;
		SqlHelper sh=new SqlHelper(); 
		//�������ݿ����
		ResultSet rs=null;
		String sql="select * from userlogin where id=? and pwd=?";
		String para[]={ul.id+"",ul.psw};
		//�������ݿ�
		sh.connection();
		//��ѯ���ݿ�
		rs=sh.query(sql, para);
		try {
			if(rs.next())
			{
				b=true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			sh.close(rs, sh.ps, sh.ct);
		}
		System.out.println("b="+b);
		return b;
	}
}
