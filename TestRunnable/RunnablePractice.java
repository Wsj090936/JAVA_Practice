package TestRunnable;
//多窗口售票
//线程安全的
class SellTicket implements Runnable{
	int ticket = 200;
	Object obj = new Object();//创建锁（同步监视器）注意不能放在run()方法里面，那样相当于创建了三个不同锁，是没有效果的
	public void run(){
		while(true){
			synchronized(obj){//添加锁
			if(ticket>0)
			{
				System.out.println(Thread.currentThread().getName()+":"+ticket--);
			}
			else
			{
				break;
			}
		}
	}
		}
}
public class RunnablePractice {
	public static void main(String[] args){
		SellTicket p = new SellTicket();
		Thread T = new Thread(p);
		T.setName("窗口一");
		T.start();
		Thread T1 = new Thread(p);
		T1.setName("窗口二");
		T1.start();
	} 
}
