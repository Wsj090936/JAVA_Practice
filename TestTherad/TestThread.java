package TestTherad;
//ͨ���̳д������߳�
public class TestThread {
public static void main(String[] args) {
	//2�������������
	SonThread p1 = new SonThread();
	//�����߳�
	p1.start();
	//main����
	for(int i = 0;i<10;i++)
	{
		System.out.println("main:"+i);
	}
}
}

//1���������࣬������̳�Therad
class SonThread extends Thread{
	public void run() 
	{
		for(int i = 0;i<10;i++)
		{
			System.out.println("Therad:"+i);
		}
	}
}
