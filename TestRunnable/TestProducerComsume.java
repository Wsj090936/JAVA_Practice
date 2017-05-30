package TestRunnable;
//����������������
public class TestProducerComsume {
public static void main(String[] args) {
	Clerk clerk = new Clerk();
	Producter P1 = new Producter(clerk);
	Consumer C1 = new Consumer(clerk);
	Thread T1 = new Thread(P1);
	T1.setName("������");
	Thread T2 = new Thread(C1);
	T2.setName("������");
	T1.start();
	T2.start();
	String i = " ";
}
}
class Producter implements Runnable{//������
	Clerk clerk;
	Producter(Clerk clerk){
		this.clerk = clerk;
	}
	public void run(){
		System.out.println("��ʼ������Ʒ");
		while(true){
			clerk.addProduct();
		}
	}
}
class Consumer implements Runnable{//������
	Clerk clerk;
	Consumer(Clerk clerk){
		this.clerk = clerk;
	}
	public void run(){
		System.out.println("��ʼ���Ѳ�Ʒ");
		while(true){
			clerk.ComsumeProduct();
		}
	}
}
class Clerk{//��Ա(������Դ)
	int product;
	public synchronized void addProduct(){//�ṩ��Ʒ
		if(product>=20){
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}else{
			try {
				Thread.currentThread().sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			product++;
			System.out.println(Thread.currentThread().getName()+"�����˵�"+product+"����Ʒ");
			notify();
		}
	}
	public synchronized void ComsumeProduct(){//���Ѳ�Ʒ
		if(product<=0){
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}else{
			try {
				Thread.currentThread().sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName()+"�����˵�"+product+"����Ʒ");
			product--;
			notify();
		}
	}
}