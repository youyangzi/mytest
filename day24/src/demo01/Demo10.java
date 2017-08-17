package demo01;

import org.apache.commons.dbutils.QueryRunner;
import org.junit.Test;

import demo01.utils.C3P0Utils;

public class Demo10 {
	/**
	 * 转账业务
	 */
	@Test
	public void transfer() {
		try {
			// 1.zhun被数据
			String outUser = "xiaoming";
			String inUser = "xiaohong";
			double money = 1000;

			// 2.处理业务
			// 付款
			QueryRunner runner = new QueryRunner(C3P0Utils.getDataSource());
			runner.update("update account set money=money-? where name=?", new Object[] {  money,outUser });
			// 收款
			runner.update("update account set money=money+? where name=?", new Object[] {  money,inUser });

			// 3.展示结果
			System.out.println("转账成功");

		} catch (Exception e) {
			System.out.println("转账失败");
			e.printStackTrace();
		}
	}
}
