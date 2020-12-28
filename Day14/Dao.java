package com.rj.bd.dao;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @desc   ����JDBC�ع���ȡһ��Dao������
 * @author 
 * @time   2020-11-11
 */
public class Dao {

	 /*������Ҫ��*/
private	   String driverName="com.mysql.jdbc.Driver";
private    String url="jdbc:mysql://127.0.0.1:3306/txl?useUnicode=true&characterEncoding=utf-8";
private    String userName="root";
private    String password="root";
	
/**
 * @desc   1.��ȡ����
 * @return
 * @throws ClassNotFoundException
 * @throws SQLException
 */
public  Connection getConnection() throws ClassNotFoundException, SQLException {
	//1.��������
	Class.forName(driverName);
	
	//2.ָ��URL/�û���+����
	Connection conn = DriverManager.getConnection(url,userName , password);
	return conn;
}

//ps:���Ƕ����ݿ�Ĳ������������չ���Ϊ�ĸ���������ɾ�Ĳ�
/**
 * @desc  3.��ѯȫ��
 * @param sql
 * @return
 * @throws ClassNotFoundException
 * @throws SQLException
 */
public List<Map<String, Object>> executeQueryForList(String sql) throws ClassNotFoundException, SQLException
{
	System.out.println("��ѯȫ��--sql--"+sql);
	Connection conn = this.getConnection();
	Statement stmt = conn.createStatement();
	ResultSet rs = stmt.executeQuery(sql);
	List<Map<String, Object>> list=rsToList(rs);
	this.releaseConection(conn, stmt, rs);
	return list;
}

/**
 * @desc  5.��ѯһ��
 * @param sql
 * @return
 * @throws SQLException 
 * @throws ClassNotFoundException 
 */
public Map<String, Object> executeQueryForMap(String sql) throws ClassNotFoundException, SQLException
{
	Connection conn=null;
	Statement stmt=null;
	ResultSet rs =null;
	
	System.out.println("��ѯһ��--sql--"+sql);
	try 
	{
		conn = this.getConnection();
		stmt = conn.createStatement();
		rs= stmt.executeQuery(sql);
		List<Map<String, Object>> list = this.rsToList(rs);
		if (!list.isEmpty()) 
		{
			return list.get(0);
		}
	} 
	finally 
	{
	  this.releaseConection(conn, stmt, rs);	
	}
	return null;
}

/**
 * @desc  6.��ѯһ���ж�����
 * @param sql
 * @return
 * @throws ClassNotFoundException
 * @throws SQLException
 */
public int executeQueryForCount(String sql) throws ClassNotFoundException, SQLException
{
	System.out.println("��ѯһ���ж�������sql:"+sql);
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	try 
	{
		conn = this.getConnection();
		stmt = conn.createStatement();
		rs = stmt.executeQuery(sql);
		if (rs.next()) 
		{
			return rs.getInt(1);
		}
	} 
	finally
	{
		this.releaseConection(conn, stmt, rs);	
	}
     
	return 0;
}

/**
 * @desc  7.ִ����ӡ�ɾ�����޸Ĳ���
 * @param sql
 * @return
 * @throws ClassNotFoundException
 * @throws SQLException
 */
public int executeUpdate(String sql) throws ClassNotFoundException, SQLException
{
	System.out.println("ִ����ӡ��޸ġ�ɾ�����Ȳ�����sql��"+sql);
	Connection conn = this.getConnection();
	Statement stmt = conn.createStatement();
	int count = stmt.executeUpdate(sql);
	this.releaseConection(conn, stmt);
	return count;
}



/**
 * @desc  8.�ر�����
 * @param conn
 * @param stmt
 * @throws SQLException 
 */
private void releaseConection(Connection conn, Statement stmt) throws SQLException {
	
	 if (stmt!=null) 
	    {
		   stmt.close();
	    }
	   if (conn!=null&!conn.isClosed()) 
	    {
		   conn.close();
	    }
	
}

/**
 * @desc  4.��rs�����ת��Ϊlist<map>
 * @param rs
 * @return
 * @throws SQLException 
 */
private List<Map<String, Object>> rsToList(ResultSet rs) throws SQLException {

	List<Map<String, Object>> rows=new ArrayList<Map<String,Object>>();
	while(rs.next())//����ѭ����
	{
		Map<String, Object> cols=new HashMap<String,Object>();
		for(int i =1;i<=rs.getMetaData().getColumnCount();i++)//����ѭ��������
		{
			switch (rs.getMetaData().getColumnType(i)) 
			{
			case Types.VARCHAR:
				cols.put(rs.getMetaData().getColumnName(i), rs.getString(i));
				break;
			case Types.INTEGER:
				cols.put(rs.getMetaData().getColumnName(i), rs.getInt(i));
				break;
			case Types.BLOB:  //ͼƬ����
				InputStream in = rs.getBinaryStream(i);
				cols.put(rs.getMetaData().getColumnName(i), in);
				break;

			default:
				cols.put(rs.getMetaData().getColumnName(i), rs.getString(i));
				break;
			}
			
		}
		rows.add(cols);
	}
	return rows;
}


/**
 * @desc  2.�ͷ�����
 * @param conn
 * @param stmt
 * @param rs
 * @throws SQLException
 */
public  void releaseConection(Connection conn, Statement stmt, ResultSet rs) throws SQLException {
	    System.out.println("releaseConection");
	   //7.�ر�����
	    if (rs!=null) 
	    {
	    	 rs.close();
		}
	    if (stmt!=null) 
	    {
		   stmt.close();
	    }
	   if (conn!=null&!conn.isClosed()) 
	    {
		   conn.close();
	    }
}
public static void main(String[] args) throws ClassNotFoundException, SQLException {
	
	Dao dao=new Dao();
	//System.out.println(dao.executeQueryForList("  select * from student  "));
	//System.out.println(dao.executeQueryForMap(" select * from student where sno='s001' "));
	System.out.println(dao.executeQueryForCount(" select count(*) from student  "));
}
	
}
