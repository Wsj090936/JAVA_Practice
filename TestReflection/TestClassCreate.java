package TestReflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import org.junit.Test;

//利用反射创建对应运行时类的对象
public class TestClassCreate {
@Test
	public void test() throws Exception{
	Class clazz = Class.forName("TestReflection.Animal");
	Animal A1 = (Animal)clazz.newInstance();//创建运行时类的对象，使用了Class类中的newInstance()方法，相当于调用了运行时类的构造器
	System.out.println(A1);
}
@Test
	public void test1(){
		Class clazz = Animal.class;
		Method[] mothods = clazz.getMethods();//获取运行时类的方法实例
		System.out.println(mothods[0].getModifiers());//public
		Constructor[] cons = clazz.getDeclaredConstructors();//获取构造器
		for(Constructor e:cons){
			System.out.println(e);
			//public TestReflection.Animal()
			//private TestReflection.Animal(java.lang.String,int)
		}
	}
@Test//获取父类的泛型
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

