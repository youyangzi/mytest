package demo03.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;

import demo03.utils.C3P0Utils;

/**
 * 专门和数据库交互
 * 提取记忆
 */
 
public class AccountDao {
	/**
	 * 付款
	 * @param outUser 付款人
	 * @param money 付款金额
	 * @throws SQLException
	 */
	public void outMoney(String outUser, double money) throws SQLException {
		QueryRunner runner = new QueryRunner();
		String sql="update account set money = money-? where name=?";
		Object[]param={money,outUser};
		runner.update(C3P0Utils.getConnection(), sql, param);
	}
	/**
	 * 收款
	 * @param inUser
	 * @param money
	 * @throws SQLException 
	 */
	public void inMoney(String inUser, double money) throws SQLException {
		QueryRunner runner = new QueryRunner();
		String sql="update account set money = money+? where name=?";
		Object[]param={money,inUser};
		runner.update(C3P0Utils.getConnection(), sql, param);
	}

}
