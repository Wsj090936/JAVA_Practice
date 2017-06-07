package TestReflection;

import java.lang.reflect.Method;

import org.junit.Test;
//通过反射获取指定的方法
public class TestGetMethod {
@Test
	public void test() throws Exception{
	//1、通过加载器获取对应运行时类
	Class clazz = getClass().getClassLoader().loadClass("TestReflection.Animal");
	//2、创建运行时类对象
	Animal p = (Animal)clazz.newInstance();
	//3、获取指定的方法
	Method show = clazz.getMethod("show");
	//4、调用指定的方法 invoke()返回的值为被调用方法的返回值，没有返回值则为null
	Object obj = show.invoke(p);//我是一只动物
	
	Method display = clazz.getMethod("display", String.class);
	Object obj1 = display.invoke(p, "猫");//我是猫
	//-------------------获取运行时类的指定方法(可以为public也可以不为public)----------
	Method info = clazz.getDeclaredMethod("info", String.class,Integer.class);
	//使得该方法可被操作
	info.setAccessible(true);
	Object obj2 = info.invoke(p, "dog",12);//dog

	System.out.println(obj2);//12
}
}
