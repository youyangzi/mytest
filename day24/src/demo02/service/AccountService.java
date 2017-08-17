package demo02.service;

import java.sql.Connection;

import org.apache.commons.dbutils.DbUtils;

import demo02.dao.AccountDao;
import demo02.utils.C3P0Utils;

/**
 * 大脑
 */
public class AccountService {
	/**
	 * 转账业务---转账事务 1、付款单元 2、收款单元 两个dao方法用同一个con对象
	 * 
	 * @param outUser
	 * @param inUser
	 * @param money
	 * @throws Exception
	 */
	public void transfer(String outUser, String inUser, double money) {

		Connection con = null;
		try {
			//1、配置con对象
			//获取con对象
			con = C3P0Utils.getConnection();
			//把自动变为手动事务  start transaction;
			con.setAutoCommit(false);
			//2、业务处理
			//付款
			AccountDao dao = new AccountDao();
			dao.outMoney(con,outUser,money);
			//收款
			dao.inMoney(con,inUser,money);
			//提交
			DbUtils.commitAndCloseQuietly(con);

		} catch (Exception e) {
			DbUtils.rollbackAndCloseQuietly(con);
			throw new RuntimeException(e);
		}
	}

}
