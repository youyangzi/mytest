package demo03.utils;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.commons.dbutils.DbUtils;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class C3P0Utils {
	// 加载默认配置
	private static DataSource dataSource = new ComboPooledDataSource();
	// 所有线程的数据共享都由local对象进行 传递共享
	private static ThreadLocal<Connection> local = new ThreadLocal<Connection>();

	/**
	 * 从连接池中 获取连接对象的方法
	 * 
	 * @return
	 * @throws SQLException
	 */
	public static Connection getConnection() throws SQLException {
		Connection result = null;
		// 1、尝试从local中获取连接 这个线程之前是否共享过数据
		result = local.get();
		// 2、判断 这个线程之前是否共享过数据
		if (result == null) {
			// 说明当前线程在local中没有共享过任何数据
			result = dataSource.getConnection();
			// 把自动事务设置为 手动事务 后，再进行共享
			result.setAutoCommit(false);
			// 把获取到的数据 共享到local中，下次就可以使用共享数据
			local.set(result);
		}
		return result;

	}

	/**
	 * 提交
	 */
	public static void commit() {
		try {
			// 获取连接
			Connection con = local.get();
			// 把con从map中解绑
			local.remove();
			// 2.执行提交
			DbUtils.commitAndCloseQuietly(con);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 回滚
	 */
	public static void rollback() {
		try {
			// 获取连接
			Connection con = local.get();
			// 把con从map中解绑
			local.remove();
			// 2.执行回滚
			DbUtils.rollbackAndCloseQuietly(con);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 获取数据源连接池-为DBUtils工具准备
	 */
	public static DataSource getDataSource() {
		return dataSource;

	}
}
