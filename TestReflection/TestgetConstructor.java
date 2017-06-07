package TestReflection;

import java.lang.reflect.Constructor;

import org.junit.Test;

//调用指定的构造器
public class TestgetConstructor {
@Test
	public void test() throws Exception{
	//1、获取运行时类
	Class clazz = getClass().getClassLoader().loadClass("TestReflection.Animal");
	//2、获取指定的构造器
	Constructor con = clazz.getDeclaredConstructor(String.class,int.class);
	con.setAccessible(true);
	//3、调用指定的构造器
	Animal p = (Animal)con.newInstance("狼",12);
	System.out.println(p);
}
}
