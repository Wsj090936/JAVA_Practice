package TestReflection;

import org.junit.Test;

//���÷��䴴����Ӧ����ʱ��Ķ���
public class TestClassCreate {
@Test
	public void test() throws Exception{
	Class clazz = Class.forName("TestReflection.Animal");
	Animal A1 = (Animal)clazz.newInstance();
	System.out.println(A1);
}
}
