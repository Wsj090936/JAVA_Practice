package TestRunnable;
//����ʵ��Runnable�ӿڵķ�ʽ�������߳�
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
	//����Runnable�ӿ�ʵ����Ķ���
	test p = new test();
	//���ö�����Ϊ�������ݵ�Thread����Ĺ�������
	Thread T = new Thread(p);
	//����start()����
	T.start();
	Thread T1 = new Thread(p);
	T1.start();
	}
}
