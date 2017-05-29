package TestRunnable;
//用两个储户向一个账户中存入6000块钱，每个储户存3000.分三次，每次存1000
//储户为线程，钱的余额为共享属性
public class Practice1 {
public static void main(String[] args) {
	Account account = new Account();//创建账户
	User user = new User(account);
	//两个储户
	Thread P1 = new Thread(user);
	Thread P2 = new Thread(user);
	P1.setName("用户一:");
	P2.setName("用户二:");
	P1.start();
	P2.start();
}
}
class Account{
	double money;//余额
	//存钱
	
	public void despite(double in)
	{
		synchronized(this){//加锁解决线程安全问题
		try {
			Thread.currentThread().sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		money += in;
		System.out.println(Thread.currentThread().getName()+":"+money);
	}
	}
}
class User implements Runnable{
	Account acc;
	public void run(){
		for(int i = 0;i <3;i++)
		{
			acc.despite(1000);
		}
	}
	User(Account acc)
	{
		this.acc = acc;
	}
}
