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
 * @desc   利用JDBC重构获取一个Dao工具类
 * @author 
 * @time   2020-11-11
 */
public class Dao {

	 /*连库四要素*/
private	   String driverName="com.mysql.jdbc.Driver";
private    String url="jdbc:mysql://127.0.0.1:3306/txl?useUnicode=true&characterEncoding=utf-8";
private    String userName="root";
private    String password="root";
	
/**
 * @desc   1.获取连接
 * @return
 * @throws ClassNotFoundException
 * @throws SQLException
 */
public  Connection getConnection() throws ClassNotFoundException, SQLException {
	//1.加载驱动
	Class.forName(driverName);
	
	//2.指定URL/用户名+密码
	Connection conn = DriverManager.getConnection(url,userName , password);
	return conn;
}

//ps:我们对数据库的操作，可以最终归纳为四个动作：增删改查
/**
 * @desc  3.查询全部
 * @param sql
 * @return
 * @throws ClassNotFoundException
 * @throws SQLException
 */
public List<Map<String, Object>> executeQueryForList(String sql) throws ClassNotFoundException, SQLException
{
	System.out.println("查询全部--sql--"+sql);
	Connection conn = this.getConnection();
	Statement stmt = conn.createStatement();
	ResultSet rs = stmt.executeQuery(sql);
	List<Map<String, Object>> list=rsToList(rs);
	this.releaseConection(conn, stmt, rs);
	return list;
}

/**
 * @desc  5.查询一条
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
	
	System.out.println("查询一条--sql--"+sql);
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
 * @desc  6.查询一共有多少条
 * @param sql
 * @return
 * @throws ClassNotFoundException
 * @throws SQLException
 */
public int executeQueryForCount(String sql) throws ClassNotFoundException, SQLException
{
	System.out.println("查询一共有多少条的sql:"+sql);
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
 * @desc  7.执行添加、删除、修改操作
 * @param sql
 * @return
 * @throws ClassNotFoundException
 * @throws SQLException
 */
public int executeUpdate(String sql) throws ClassNotFoundException, SQLException
{
	System.out.println("执行添加、修改、删除、等操作的sql："+sql);
	Connection conn = this.getConnection();
	Statement stmt = conn.createStatement();
	int count = stmt.executeUpdate(sql);
	this.releaseConection(conn, stmt);
	return count;
}



/**
 * @desc  8.关闭连接
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
 * @desc  4.将rs结果集转变为list<map>
 * @param rs
 * @return
 * @throws SQLException 
 */
private List<Map<String, Object>> rsToList(ResultSet rs) throws SQLException {

	List<Map<String, Object>> rows=new ArrayList<Map<String,Object>>();
	while(rs.next())//控制循环行
	{
		Map<String, Object> cols=new HashMap<String,Object>();
		for(int i =1;i<=rs.getMetaData().getColumnCount();i++)//里面循环控制列
		{
			switch (rs.getMetaData().getColumnType(i)) 
			{
			case Types.VARCHAR:
				cols.put(rs.getMetaData().getColumnName(i), rs.getString(i));
				break;
			case Types.INTEGER:
				cols.put(rs.getMetaData().getColumnName(i), rs.getInt(i));
				break;
			case Types.BLOB:  //图片类型
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
 * @desc  2.释放连接
 * @param conn
 * @param stmt
 * @param rs
 * @throws SQLException
 */
public  void releaseConection(Connection conn, Statement stmt, ResultSet rs) throws SQLException {
	    System.out.println("releaseConection");
	   //7.关闭连接
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
