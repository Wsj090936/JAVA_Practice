package TestReflection;

import java.lang.reflect.Method;

import org.junit.Test;
//ͨ�������ȡָ���ķ���
public class TestGetMethod {
@Test
	public void test() throws Exception{
	//1��ͨ����������ȡ��Ӧ����ʱ��
	Class clazz = getClass().getClassLoader().loadClass("TestReflection.Animal");
	//2����������ʱ�����
	Animal p = (Animal)clazz.newInstance();
	//3����ȡָ���ķ���
	Method show = clazz.getMethod("show");
	//4������ָ���ķ��� invoke()���ص�ֵΪ�����÷����ķ���ֵ��û�з���ֵ��Ϊnull
	Object obj = show.invoke(p);//����һֻ����
	
	Method display = clazz.getMethod("display", String.class);
	Object obj1 = display.invoke(p, "è");//����è
	//-------------------��ȡ����ʱ���ָ������(����ΪpublicҲ���Բ�Ϊpublic)----------
	Method info = clazz.getDeclaredMethod("info", String.class,Integer.class);
	//ʹ�ø÷����ɱ�����
	info.setAccessible(true);
	Object obj2 = info.invoke(p, "dog",12);//dog

	System.out.println(obj2);//12
}
}
