package TestReflection;
//�����ʵ��
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.junit.Test;

public class TestReflection {
	@Test//Classʵ���Ļ�ȡ
	public void test4() throws Exception{
		//1��ͨ������ʱ��Ķ����ȡ
		Animal A = new Animal();
		Class clazz = A.getClass();
		System.out.println(clazz);
		//2��ͨ������ʱ��ı���.class���Ի�ȡ
		Class clazz1 = Animal.class;
		System.out.println(clazz1);
		//3��ͨ��Class�ľ�̬������ȡ
		String  ClassName = "TestReflection.Animal";
		Class clazz2 = Class.forName(ClassName);
		//clazz2.newInstance();
		System.out.println(clazz2);
		//4��ͨ����ļ�����
		ClassLoader classLoader = getClass().getClassLoader();
		Class clazz3 = classLoader.loadClass(ClassName);
		System.out.println(clazz3);
	}
@Test
	public void test3() throws Exception{
	Class<Animal> clazz = Animal.class;
	Animal A = clazz.newInstance();
	Field f1 = clazz.getField("name");//���ù�������
	f1.set(A, "dog");
	System.out.println(A);
	Field f2 = clazz.getDeclaredField("age");//����˽������
	f2.setAccessible(true);
	f2.set(A, 12);
	System.out.println(A);
	Method f3 = clazz.getMethod("display", String.class);//���÷���
	f3.invoke(A, "dog");
}
}
