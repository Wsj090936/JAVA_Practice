package TestRunnable;
//线程通信  wait()  notify()/notifyAll()
/*
 * 实现1~100数字的交替打印
 */
public class TestCommunication {
	public static void main(String[] args){
	test2 p = new test2();
	Thread P1 = new Thread(p);
	Thread P2 = new Thread(p);
	P1.setName("线程1");
	P2.setName("线程2");
	P1.start();
	P2.start();
	}
	
}
//创建线程
class test2 implements Runnable{
	int num = 1;
	public void run(){
		while(true){
			synchronized(this){
				notify();//唤醒
			if(num<=100){
				try {
					Thread.currentThread().sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName()+":"+num);
				num++;
			}else{
				break;
			}
			try {
				wait();//挂起
			} catch (InterruptedException e) {
				e.printStackTrace();
			  }
			}
		}
	}
}
