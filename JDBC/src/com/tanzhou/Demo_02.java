package com.tanzhou;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * jdbc��������ѯ���ݱ���ȡ�����
 */
public class Demo_02 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// 1.ע������
		Class.forName("com.mysql.jdbc.Driver");
		// 2.��ȡ���Ӷ���
		String url = "jdbc:mysql://localhost:3306/mybase";
		String user = "root";
		String password = "liangchen";
		Connection con = DriverManager.getConnection(url, user, password);
		// 3.��ȡִ��SQL������
		Statement stat = con.createStatement();
		// ��ѯ���
		String sql = "select * from sort";
		// 4.����ִ���߶���ķ�����ִ��SQL��� ����ֵResultSet�ӿ�ʵ����Ķ���
		ResultSet rs = stat.executeQuery(sql);
		// 5.�������� rssultset boolena next ����true���н���� ������false��û��
		while (rs.next()) {
			// ��ȡÿ�����ݣ�ʹ��getxxx����
			System.out.println(rs.getString("sid") + "   " + rs.getString("sname") + "  " + rs.getString("sprice")
					+ "  " + rs.getString("sdesc"));
		}

		// 6.�ر���Դ �ȿ���ص�˳��
		rs.close();
		stat.close();
		con.close();

	}
}
