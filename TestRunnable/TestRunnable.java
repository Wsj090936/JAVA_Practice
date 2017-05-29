package TestRunnable;
//利用实现Runnable接口的方式创建多线程
class test implements Runnable{
	int i = 100;
	Object obj = new Object();
	public void run(){	
		while(true){
			synchronized(obj){
			if(i>0)
			{
				System.out.println(Thread.currentThread().getName()+":"+i--);
			}
			else{
				break;
			}
		}
	}
	}
}
public class TestRunnable {
	public static void main(String[] args) {
	//创建Runnable接口实现类的对象
	test p = new test();
	//将该对象作为参数传递到Thread对象的构造器中
	Thread T = new Thread(p);
	//调用start()方法
	T.start();
	Thread T1 = new Thread(p);
	T1.start();
	}
}
