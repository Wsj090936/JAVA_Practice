package TestRunnable;
//������������һ���˻��д���6000��Ǯ��ÿ��������3000.�����Σ�ÿ�δ�1000
//����Ϊ�̣߳�Ǯ�����Ϊ��������
public class Practice1 {
public static void main(String[] args) {
	Account account = new Account();//�����˻�
	User user = new User(account);
	//��������
	Thread P1 = new Thread(user);
	Thread P2 = new Thread(user);
	P1.setName("�û�һ:");
	P2.setName("�û���:");
	P1.start();
	P2.start();
}
}
class Account{
	double money;//���
	//��Ǯ
	
	public void despite(double in)
	{
		synchronized(this){//��������̰߳�ȫ����
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
