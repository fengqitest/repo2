package com.tz.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class test {

	public static void main(String[] args) {
		try {
			//1.��������
			Class.forName("com.mysql.jdbc.Driver");
			//2.�������
			String url="jdbc:mysql://localhost:3306/user";
			String user="root";
			String password="123456";
			Connection conn = DriverManager.getConnection(url, user, password);
			//3.���sql���ƽ̨
			Statement stat = conn.createStatement();
			//��дsql���
			String sql="insert into userform values(6,'С��01',2000)";	
			//4.ִ��SQL���
			int i = stat.executeUpdate(sql);
			//�ж��������Ƿ�ɹ�
			if(i>0){
				 System.out.println("�ɹ����:  "+i+"   ������");
			 } 
			//5.�ر���Դ (�ȿ����)
			stat.close();
			conn.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}

}
