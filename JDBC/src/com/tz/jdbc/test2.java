package com.tz.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class test2 {

	public static void main(String[] args) {
		//ע�⣺   ���������connection������ͬһ��
		Connection conn=null;
		try {
			//1.��������
			Class.forName("com.mysql.jdbc.Driver");
			//2.�������
			String url="jdbc:mysql://localhost:3306/user";
			String user="root";
			String password="123456";
			conn = DriverManager.getConnection(url, user, password);
		//�ֶ���������
		conn.setAutoCommit(false);    //���Զ�����Ϊ�ֶ��ύ
			
			//3.���sql���ƽ̨
			Statement stat = conn.createStatement();
			//��дsql���
			String sql="insert into userform values(8,'����001',2000)";	 //һ��sql�����һ������
			
			//4.ִ��SQL���
			 stat.executeUpdate(sql);
		 
		//�ύ����
		conn.commit();
			//�쳣
		     //int x=1/0;
			/*//int i = stat.executeUpdate(sql);
			//�ж��������Ƿ�ɹ�
			if(i>0){
				 System.out.println("�ɹ����:  "+i+"   ������");
			 } */
			//5.�ر���Դ (�ȿ����)
			stat.close();
			conn.close();
			
		} catch (Exception e) {
			try {
				//����������쳣 ��ִ�� 
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		
		
		
		
	}

}
