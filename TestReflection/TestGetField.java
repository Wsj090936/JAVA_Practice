package TestReflection;

import java.lang.reflect.Field;

import org.junit.Test;

//通过反射获取指定的属性
public class TestGetField {
	@Test
	public void test() throws Exception{
		Class clazz = Class.forName("TestReflection.Animal");
		//1、创建运行时类对象
		Animal p = (Animal)clazz.newInstance();
		
		//2、获取指定属性  通过getField(String fieldname)方法只能够获取到当前运行时类中声明为public的指定名为fieldname的属性
		Field name = clazz.getField("name");
		name.set(p, "cat");//将运行时类的指定属性赋值
		System.out.println(p);//Animal [name=cat, age=0]
		//3、通过getDeclaredField()方法能够获取到当前运行时类中指定名为fieldname的属性
		Field age = clazz.getDeclaredField("age");
		//4、由于权限修饰符的原因，在给属性赋值之前使用setAccessible()方法使得属性可被操作(即权限为public之外的其他权限修饰符)
		age.setAccessible(true);
		age.set(p, 6);
		System.out.println(p);//Animal [name=cat, age=6]
	}
}
