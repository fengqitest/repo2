package com.tanzhou.JDBCUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * jdbc�����࣬
 */
public class JDBCUtils {
	// ��̬˽�� һ�㹤���඼��ֱ�ӵ���
	private static final String driverClassName;
	private static final String url;
	private static final String username;
	private static final String password;
	// ��дһ����̬�����
	static {
		driverClassName = "com.mysql.jdbc.Driver";
		url = "jdbc:mysql:///mybase";
		username = "root";
		password = "1234";
	}

	/**
	 * ע������
	 */
	public static void loadDriver() {
		try {
			Class.forName(driverClassName);
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		}
	}

	/**
	 * �������
	 */
	public static Connection getconnection() {
		// ��connection�ŵ�����
		Connection conn = null;
		try {
			//
			loadDriver();
			conn = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}

	/**
	 * �ͷ���Դ
	 */
	// ��ɾ��
	public static void close(Connection conn, Statement st) {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}

		}
		conn = null;

		if (st != null) {
			try {
				st.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}

		}
		st = null;
	}
	// ��

	public static void close(Connection conn, Statement st, ResultSet rs) {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}

		}
		conn = null;

		if (st != null) {
			try {
				st.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}

		}
		st = null;

		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}

		}
		rs = null;

	}

}
