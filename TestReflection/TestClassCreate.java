package TestReflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import org.junit.Test;

//���÷��䴴����Ӧ����ʱ��Ķ���
public class TestClassCreate {
@Test
	public void test() throws Exception{
	Class clazz = Class.forName("TestReflection.Animal");
	Animal A1 = (Animal)clazz.newInstance();//��������ʱ��Ķ���ʹ����Class���е�newInstance()�������൱�ڵ���������ʱ��Ĺ�����
	System.out.println(A1);
}
@Test
	public void test1(){
		Class clazz = Animal.class;
		Method[] mothods = clazz.getMethods();//��ȡ����ʱ��ķ���ʵ��
		System.out.println(mothods[0].getModifiers());//public
		Constructor[] cons = clazz.getDeclaredConstructors();//��ȡ������
		for(Constructor e:cons){
			System.out.println(e);
			//public TestReflection.Animal()
			//private TestReflection.Animal(java.lang.String,int)
		}
	}
@Test//��ȡ����ķ���
	public void test2(){
	Class clazz = Animal.class;
	Type type = clazz.getGenericSuperclass();
	ParameterizedType param = (ParameterizedType)type;
	Type[] ars = param.getActualTypeArguments();
	System.out.println(((Class)ars[0]).getName());//java.lang.String
	System.out.println(13/5);
	byte[] a;
	a = String.e

} 
}

