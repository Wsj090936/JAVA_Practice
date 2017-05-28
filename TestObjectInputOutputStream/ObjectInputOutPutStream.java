package TestObjectInputOutputStream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import org.junit.Test;

//���л��뷴���л���ʵ��  ����ObjectOutputStream��ObjectInputStream
public class ObjectInputOutPutStream {
@Test//���л���ʵ��
	public void testObjectOutputStream(){
	//����Ҫ�����л��Ķ���
	TestClass1 p1 = new TestClass1("˧��",25);
	TestClass1 p2 = new TestClass1("�к�",14);
	ObjectOutputStream oos = null;
	try{
	//�ṩ������
	oos = new ObjectOutputStream(new FileOutputStream("test1.txt"));//���������л���test1.txt�ļ���
	//��ʼ���л�
	oos.writeObject(p1);
	oos.flush();
	oos.writeObject(p2);
	oos.flush();
	}catch(Exception e)
	{
		e.printStackTrace();
	}
	finally{
	//�ر��ļ�
	if(oos != null)
	{
		try {
			oos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
  }
}
@Test//���ļ��еĶ����ȡ��ת�����ڴ��У������л���
	public void testObjectInputStream(){
	ObjectInputStream ois = null;
	try {
		ois = new ObjectInputStream(new FileInputStream("test1.txt"));
		
		//��ʼ��Ӳ���е��ļ�ת��Ϊ��Ӧ�Ķ���
		TestClass1 P1 = (TestClass1)ois.readObject();//ͨ��readObject()������ȡ����
		System.out.println(P1);
		TestClass1 P2 = (TestClass1)ois.readObject();
		System.out.println(P2);
	}catch (Exception e) {
		e.printStackTrace();
	}
	finally{
			if(ois != null)
				{
					try {
						ois.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
	}
}

}
//����һ�����Ա����л�����
class TestClass1 implements Serializable{
	private static final long serialVersionUID = 6816958524166979064L;
	String name;
	Integer age;
	TestClass1(String name,Integer age)
	{
		this.name = name;
		this.age = age;
	}
	@Override
	public String toString() {
		return "TestClass1 [name=" + name + ", age=" + age + "]";
	}
}
