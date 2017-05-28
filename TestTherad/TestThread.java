package TestTherad;
//通过继承创建多线程
public class TestThread {
public static void main(String[] args) {
	//2、创建子类对象
	SonThread p1 = new SonThread();
	//开启线程
	p1.start();
	//main方法
	for(int i = 0;i<10;i++)
	{
		System.out.println("main:"+i);
	}
}
}

//1、创建子类，让子类继承Therad
class SonThread extends Thread{
	public void run() 
	{
		for(int i = 0;i<10;i++)
		{
			System.out.println("Therad:"+i);
		}
	}
}
