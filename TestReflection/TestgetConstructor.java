package TestReflection;

import java.lang.reflect.Constructor;

import org.junit.Test;

//����ָ���Ĺ�����
public class TestgetConstructor {
@Test
	public void test() throws Exception{
	//1����ȡ����ʱ��
	Class clazz = getClass().getClassLoader().loadClass("TestReflection.Animal");
	//2����ȡָ���Ĺ�����
	Constructor con = clazz.getDeclaredConstructor(String.class,int.class);
	con.setAccessible(true);
	//3������ָ���Ĺ�����
	Animal p = (Animal)con.newInstance("��",12);
	System.out.println(p);
}
}
