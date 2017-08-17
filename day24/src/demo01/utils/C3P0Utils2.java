package demo01.utils;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class C3P0Utils2 {
	// 加载默认配置
	private static DataSource dataSource=new ComboPooledDataSource();
	// 从连接池中 获取连接对象的方法	 
	public static Connection getConnection() throws SQLException{
		return dataSource.getConnection();
	}
	//获取数据源连接池 为DBUtils工具准备
	public static DataSource getDataSource(){
		return dataSource;
	}		
}
