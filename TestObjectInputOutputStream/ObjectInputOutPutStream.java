package TestObjectInputOutputStream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import org.junit.Test;

//序列化与反序列化的实现  利用ObjectOutputStream与ObjectInputStream
public class ObjectInputOutPutStream {
@Test//序列化的实现
	public void testObjectOutputStream(){
	//创建要被序列化的对象
	TestClass1 p1 = new TestClass1("帅哥",25);
	TestClass1 p2 = new TestClass1("男孩",14);
	ObjectOutputStream oos = null;
	try{
	//提供对象流
	oos = new ObjectOutputStream(new FileOutputStream("test1.txt"));//将对象序列化到test1.txt文件中
	//开始序列化
	oos.writeObject(p1);
	oos.flush();
	oos.writeObject(p2);
	oos.flush();
	}catch(Exception e)
	{
		e.printStackTrace();
	}
	finally{
	//关闭文件
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
@Test//将文件中的对象读取后转换到内存中（反序列化）
	public void testObjectInputStream(){
	ObjectInputStream ois = null;
	try {
		ois = new ObjectInputStream(new FileInputStream("test1.txt"));
		
		//开始将硬盘中的文件转换为相应的对象
		TestClass1 P1 = (TestClass1)ois.readObject();//通过readObject()方法读取对象
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
//定义一个可以被序列化的类
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
