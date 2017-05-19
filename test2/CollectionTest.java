package test2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;

import org.junit.Test;

public class CollectionTest {
	@Test
	public void testCollection1(){
		//1:size():���ؼ����е�Ԫ�ظ���
		Collection A = new ArrayList();
		System.out.println(A.size());
		//2:add(Object e):�򼯺������һ��Ԫ��
		A.add(12);
		System.out.println(A.size());
		//3:addAll(Collection obj):������obj�е�����Ԫ�ض���ӵ�������ȥ
		Collection obj = new ArrayList();
		obj.add(new Date());
		obj.add("AA");
		A.addAll(obj);
		System.out.println(A.size());
		System.out.println(A);//��ӡ�����е�Ԫ��
		//4:clear():��ռ����е�Ԫ��
		A.clear();
		System.out.println(A.size());
		//5:isEmpty():�жϼ����Ƿ�Ϊ��
		System.out.println(A.isEmpty());	
	}
	@Test
	public void testCollection2(){
		//6:contains(Object e):�ж�e�Ƿ�����ڵ�ǰ������
		Collection A = new ArrayList();
		Collection C = new ArrayList();
		A.add("BB");
		A.add("AA");
		A.add(123);
		C.addAll(A);
		System.out.println(A.contains("BB"));//true
		//7:containsAll(Collection e):�жϵ�ǰ�����Ƿ�����˼���e������Ԫ��  ���ڷ���true  ��֮����false
		Collection B = new ArrayList();
		B.add("BB");
		B.add("AA");
		System.out.println(A.containsAll(B));//true
		//8:retainAll(Collection e):��e�뵱ǰ���ϵĹ���Ԫ�ز����ظ���ǰ����,�ɹ�����true��֮����false
		A.retainAll(B);
		System.out.println(A);//[BB,AA]
		//9:remove(Object e):ɾ����ǰ�����е�Ԫ��e�����ɹ�������true����֮����false
		System.out.println(A.remove("BB"));//true
		//10:removeAll(Collection e):ɾ����ǰ��������e�����е�Ԫ��,�ɹ�����true����֮����false
		C.removeAll(B);
		System.out.println(C);//[123]
	}
	@Test
	public void testCollection3(){
		Collection A = new ArrayList();
		Collection C = new ArrayList();
		A.add("BB");
		A.add("AA");
		A.add(123);
		C.addAll(A);
		//11:equals() �ж����������Ƿ���ȫ��ͬ
			System.out.println(A.equals(C));//true
		//12:hashCode() 
			System.out.println(A.hashCode());//2124026
		//13:toArray() ����ǰ����ת��Ϊ����
			A.toArray();
		//14:iterator() ����һ��Iterator���͵Ķ��󣬴Ӷ�����ʵ�ּ��ϵı���
			//���ϵı��������������hasNext()������next()����ʹ��
			Iterator Obj = C.iterator();
			while(Obj.hasNext())
			{
				System.out.println(Obj.next());//BB  AA  123
			}
			for(Object each:C)
			{
				System.out.println(each);
			}
		
	}
}
