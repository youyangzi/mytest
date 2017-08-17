package demo01.utils;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class C3P0Utils {
	// 加载默认配置
	private static DataSource dataSource = new ComboPooledDataSource();

	/**
	 * 从连接池中 获取连接对象的方法
	 * 
	 * @throws SQLException
	 */
	public static Connection getConnection() throws SQLException {
		Connection result = null;
		result = dataSource.getConnection();
		return result;
	}

	/**
	 * 获取数据源连接池 为DBUtils工具准备
	 */
	public static DataSource getDataSource() {
		return dataSource;

	}

}
