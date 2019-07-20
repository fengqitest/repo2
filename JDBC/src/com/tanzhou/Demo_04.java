package com.tanzhou;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

/*
 * ��ֹSQL����
 * ��ʾԤ����� SQL ���Ķ���

  SQL ��䱻Ԥ���벢�洢�� PreparedStatement �����С�Ȼ�����ʹ�ô˶����θ�Ч��ִ�и���䡣
 */
public class Demo_04 {
	public static void main(String[] args) throws Exception {
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
		// ִ��SQL��� ��ѯ�û��������� Connection ����PreparedStatement����ȡ�ӿڵ�ʵ����
		// ִ��SQL��� ��ѯ�û��������� ����ռλ�� ��
		String sql = "select * from user where username =? and password =?";
		System.out.println(sql);
		// SQL���Ĳ���ȫ�������ʺ�ռλ��
		PreparedStatement pstat = con.prepareStatement(sql);
		// ����pstat�����set�����������ʺ�ռλ���ϵĲ���
		pstat.setObject(1, user1);
		pstat.setObject(2, pass);

		// ��ȡ�����
		ResultSet rs = pstat.executeQuery();
		// ���������
		while (rs.next()) {

			System.out.println(rs.getString("username") + "  " + rs.getString("password"));
		}
		// �ر���Դ
		rs.close();
		stat.close();
		con.close();
	}
}
