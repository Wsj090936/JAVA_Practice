package TestRunnable;
//�ര����Ʊ
//�̰߳�ȫ��
class SellTicket implements Runnable{
	int ticket = 200;
	Object obj = new Object();//��������ͬ����������ע�ⲻ�ܷ���run()�������棬�����൱�ڴ�����������ͬ������û��Ч����
	public void run(){
		while(true){
			synchronized(obj){//�����
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
		T.setName("����һ");
		T.start();
		Thread T1 = new Thread(p);
		T1.setName("���ڶ�");
		T1.start();
	} 
}
