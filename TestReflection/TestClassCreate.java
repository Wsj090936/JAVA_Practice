package TestReflection;

import org.junit.Test;

//利用反射创建对应运行时类的对象
public class TestClassCreate {
@Test
	public void test() throws Exception{
	Class clazz = Class.forName("TestReflection.Animal");
	Animal A1 = (Animal)clazz.newInstance();
	System.out.println(A1);
}
}
