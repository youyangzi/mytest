package demo02;

import org.junit.Test;

import demo02.service.AccountService;

public class Demo02 {
	/**
	 * 入口
	 */
	@Test
	public void transfer(){
		try{
			//1.准备数据
			String outUser = "xiaoming";
			String inUser = "xiaohong";
			double money = 1000;
			//2.处理业务
			AccountService service = new AccountService();
			service.transfer(outUser, inUser, money);
			//3.结果展示
			System.out.println("转账成功");
			
		}catch(Exception e){
			System.out.println("转账失败");
			e.printStackTrace();
		}
	}
}
