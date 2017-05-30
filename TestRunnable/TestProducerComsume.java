package TestRunnable;
//生产者消费者例题
public class TestProducerComsume {
public static void main(String[] args) {
	Clerk clerk = new Clerk();
	Producter P1 = new Producter(clerk);
	Consumer C1 = new Consumer(clerk);
	Thread T1 = new Thread(P1);
	T1.setName("生产者");
	Thread T2 = new Thread(C1);
	T2.setName("消费者");
	T1.start();
	T2.start();
	String i = " ";
}
}
class Producter implements Runnable{//生产者
	Clerk clerk;
	Producter(Clerk clerk){
		this.clerk = clerk;
	}
	public void run(){
		System.out.println("开始生产产品");
		while(true){
			clerk.addProduct();
		}
	}
}
class Consumer implements Runnable{//消费者
	Clerk clerk;
	Consumer(Clerk clerk){
		this.clerk = clerk;
	}
	public void run(){
		System.out.println("开始消费产品");
		while(true){
			clerk.ComsumeProduct();
		}
	}
}
class Clerk{//店员(共用资源)
	int product;
	public synchronized void addProduct(){//提供产品
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
			System.out.println(Thread.currentThread().getName()+"生产了第"+product+"个产品");
			notify();
		}
	}
	public synchronized void ComsumeProduct(){//消费产品
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
			System.out.println(Thread.currentThread().getName()+"消费了第"+product+"个产品");
			product--;
			notify();
		}
	}
}