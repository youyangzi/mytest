package demo03;

import org.junit.Test;

import demo03.service.AccountService;

public class Demo3 {
	 /**
	  * 入口
	  */
	@Test
	public void transfer(){
		try {
			//1.准备数据
			String outUser="xiaoming";
			String inUser="xiaohong";
			double money =1000;
			//2.处理业务
			/*AccountService service = new AccountService();
			service.transfer(outUser,inUser,money);*/
			new AccountService().transfer(outUser, inUser, money);
			//3.展示结果
			System.out.println("转账成功");
			
		} catch (Exception e) {
			System.out.println("转账失败");
			e.printStackTrace();
		}
	}
	@Test
	public void  run(){
		//map
		ThreadLocal<String>tl=new ThreadLocal<String>();
		//一个线程只能共享一个数据
		//存储键值对  
		tl.set("laowang");
		//获取当前线程任意位置
		String val =tl.get();
		System.out.println(val);
		
	}
}
