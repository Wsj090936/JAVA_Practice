package TestReflection;
//反射的实现
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.junit.Test;

public class TestReflection {
	@Test//Class实例的获取
	public void test4() throws Exception{
		//1、通过运行时类的对象获取
		Animal A = new Animal();
		Class clazz = A.getClass();
		System.out.println(clazz);
		//2、通过运行时类的本身.class属性获取
		Class clazz1 = Animal.class;
		System.out.println(clazz1);
		//3、通过Class的静态方法获取
		String  ClassName = "TestReflection.Animal";
		Class clazz2 = Class.forName(ClassName);
		//clazz2.newInstance();
		System.out.println(clazz2);
		//4、通过类的加载器
		ClassLoader classLoader = getClass().getClassLoader();
		Class clazz3 = classLoader.loadClass(ClassName);
		System.out.println(clazz3);
	}
@Test
	public void test3() throws Exception{
	Class<Animal> clazz = Animal.class;
	Animal A = clazz.newInstance();
	Field f1 = clazz.getField("name");//调用公有属性
	f1.set(A, "dog");
	System.out.println(A);
	Field f2 = clazz.getDeclaredField("age");//调用私有属性
	f2.setAccessible(true);
	f2.set(A, 12);
	System.out.println(A);
	Method f3 = clazz.getMethod("display", String.class);//调用方法
	f3.invoke(A, "dog");
}
}
