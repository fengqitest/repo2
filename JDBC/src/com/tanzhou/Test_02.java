package com.tanzhou;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.tanzhou.JDBCUtils.JDBCUtils2;

/*
 * jdbc������Ĳ���
 */
public class Test_02 {
public static void main(String[] args) throws SQLException {
	      //���ù�����ķ���
	
	   Connection  conn =  JDBCUtils2.getconnection();
	     //��дSQL
	   String sql = "select sname from sort";
	   //Ԥ����
	   PreparedStatement pst  = conn.prepareStatement(sql);
	   //��������
	    ResultSet rs =  pst.executeQuery();
	    while(rs.next()){
	    	System.out.println(rs.getString("sname"));
	    }
	    //�ر���Դ
	    JDBCUtils2.close(conn, pst, rs);
}
}
