package demo02.dao;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
/**
 * 专门和数据库交互
 * 提取记忆
 */
public class AccountDao {
	
	/**
	 * 付款
	 * @param con 
	 * @param outUser 付款人
	 * @param money 付款金额
	 * @throws SQLException
	 */
	public void outMoney(Connection con, String outUser, double money) throws SQLException {
		QueryRunner runner = new QueryRunner();
		String sql="update account set money =money-? where name=?";
		Object []param={money,outUser};
		runner.update(con,sql, param);
		
	}
	
	/**
	 * 收款
	 * @param con 
	 * @param inUser
	 * @param money
	 * @throws SQLException 
	 */
	public void inMoney(Connection con, String inUser, double money) throws SQLException {
		QueryRunner runner = new QueryRunner();
		String sql="update account set money =money+? where name=?";
		Object []param={money,inUser};
		runner.update(con,sql, param);
		
		
	}

}
