package TestRunnable;
//�߳�ͨ��  wait()  notify()/notifyAll()
/*
 * ʵ��1~100���ֵĽ����ӡ
 */
public class TestCommunication {
	public static void main(String[] args){
	test2 p = new test2();
	Thread P1 = new Thread(p);
	Thread P2 = new Thread(p);
	P1.setName("�߳�1");
	P2.setName("�߳�2");
	P1.start();
	P2.start();
	}
	
}
//�����߳�
class test2 implements Runnable{
	int num = 1;
	public void run(){
		while(true){
			synchronized(this){
				notify();//����
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
				wait();//����
			} catch (InterruptedException e) {
				e.printStackTrace();
			  }
			}
		}
	}
}
