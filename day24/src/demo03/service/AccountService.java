package demo03.service;

import demo03.dao.AccountDao;
import demo03.utils.C3P0Utils;

public class AccountService {

	public void transfer(String outUser, String inUser, double money) {
		/**
		 * 转账业务---转账事务 1、付款单元 2、收款单元 两个dao方法用同一个con对象
		 * 
		 * @param outUser
		 * @param inUser
		 * @param money
		 * @throws Exception
		 */
		try {
			// 付款
			AccountDao dao = new AccountDao();
			dao.outMoney(outUser, money);
			// 收款
			dao.inMoney(inUser, money);
			// 提交
			C3P0Utils.commit();
		} catch (Exception e) {
			// 回滚
			C3P0Utils.rollback();
			// service将所有抓住的异常抛给入口处理
			throw new RuntimeException(e);
		}

	}

}
