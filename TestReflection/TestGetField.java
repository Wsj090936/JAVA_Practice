package TestReflection;

import java.lang.reflect.Field;

import org.junit.Test;

//ͨ�������ȡָ��������
public class TestGetField {
	@Test
	public void test() throws Exception{
		Class clazz = Class.forName("TestReflection.Animal");
		//1����������ʱ�����
		Animal p = (Animal)clazz.newInstance();
		
		//2����ȡָ������  ͨ��getField(String fieldname)����ֻ�ܹ���ȡ����ǰ����ʱ��������Ϊpublic��ָ����Ϊfieldname������
		Field name = clazz.getField("name");
		name.set(p, "cat");//������ʱ���ָ�����Ը�ֵ
		System.out.println(p);//Animal [name=cat, age=0]
		//3��ͨ��getDeclaredField()�����ܹ���ȡ����ǰ����ʱ����ָ����Ϊfieldname������
		Field age = clazz.getDeclaredField("age");
		//4������Ȩ�����η���ԭ���ڸ����Ը�ֵ֮ǰʹ��setAccessible()����ʹ�����Կɱ�����(��Ȩ��Ϊpublic֮�������Ȩ�����η�)
		age.setAccessible(true);
		age.set(p, 6);
		System.out.println(p);//Animal [name=cat, age=6]
	}
}
