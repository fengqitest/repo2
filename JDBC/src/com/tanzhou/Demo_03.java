package com.tanzhou;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/*
 * ��ʾSQLע�� 
 * 
 */
public class Demo_03 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// 1.ע������
		Class.forName("com.mysql.jdbc.Driver");
		// 2.��ȡ���Ӷ���
		String url = "jdbc:mysql://localhost:3306/mybase";
		String user = "root";
		String password = "liangchen";
		Connection con = DriverManager.getConnection(url, user, password);
		// 3.��ȡִ�����
		Statement stat = con.createStatement();
		// ����¼��
		Scanner sc = new Scanner(System.in);
		String user1 = sc.nextLine();
		String pass = sc.nextLine();
		// 4.ִ��SQL��� ��ѯ�û���������
		String sql = "select * from user where username ='" + user1 + "+' and password ='" + pass + "'";
		System.out.println(sql);

		// 5.�����
		ResultSet rs = stat.executeQuery(sql);
		// ���������
		while (rs.next()) {
			System.out.println(rs.getString("username") + "  " + rs.getString("password"));
		}
		//6. �ر���Դ
		rs.close();
		stat.close();
		con.close();
	}
}
