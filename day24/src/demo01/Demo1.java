package demo01;

import org.apache.commons.dbutils.QueryRunner;
import org.junit.Test;

import demo01.utils.C3P0Utils;

public class Demo1 {
	/**
	 * 转账业务
	 */
	@Test
	public void transfer() {
		try {
			// 准备数据
			String outUser = "xiaoming";// 付款人
			String inUser = "xiaohong";// 收款人
			double money = 1000;// 转账金额
			// 业务处理
			// 付款
			QueryRunner run = new QueryRunner(C3P0Utils.getDataSource());
			run.update("update account set money=money-? where name=?", 
					new Object[] { money, outUser });
			// 收款
			run.update("update account set money=money+? where name=?",
					new Object[] { money, inUser });

			// 处理结果的展示
			System.out.println("转账成功");
		} catch (Exception e) {
			System.out.println("转账失败");
			e.printStackTrace();
		}
	}

}
