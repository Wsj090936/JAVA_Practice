package test2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;

import org.junit.Test;

public class CollectionTest {
	@Test
	public void testCollection1(){
		//1:size():返回集合中的元素个数
		Collection A = new ArrayList();
		System.out.println(A.size());
		//2:add(Object e):向集合中添加一个元素
		A.add(12);
		System.out.println(A.size());
		//3:addAll(Collection obj):将集合obj中的所有元素都添加到集合中去
		Collection obj = new ArrayList();
		obj.add(new Date());
		obj.add("AA");
		A.addAll(obj);
		System.out.println(A.size());
		System.out.println(A);//打印集合中的元素
		//4:clear():清空集合中的元素
		A.clear();
		System.out.println(A.size());
		//5:isEmpty():判断集合是否为空
		System.out.println(A.isEmpty());	
	}
	@Test
	public void testCollection2(){
		//6:contains(Object e):判断e是否存在于当前集合中
		Collection A = new ArrayList();
		Collection C = new ArrayList();
		A.add("BB");
		A.add("AA");
		A.add(123);
		C.addAll(A);
		System.out.println(A.contains("BB"));//true
		//7:containsAll(Collection e):判断当前集合是否包含了集合e的所有元素  存在返回true  反之返回false
		Collection B = new ArrayList();
		B.add("BB");
		B.add("AA");
		System.out.println(A.containsAll(B));//true
		//8:retainAll(Collection e):求e与当前集合的共有元素并返回给当前集合,成功返回true反之返回false
		A.retainAll(B);
		System.out.println(A);//[BB,AA]
		//9:remove(Object e):删除当前集合中的元素e，若成功，返回true，反之返回false
		System.out.println(A.remove("BB"));//true
		//10:removeAll(Collection e):删除当前集合中与e所共有的元素,成功返回true，反之返回false
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
		//11:equals() 判断两个集合是否完全相同
			System.out.println(A.equals(C));//true
		//12:hashCode() 
			System.out.println(A.hashCode());//2124026
		//13:toArray() 将当前集合转换为数组
			A.toArray();
		//14:iterator() 返回一个Iterator类型的对象，从而可以实现集合的遍历
			//集合的遍历方法可以配合hasNext()方法与next()方法使用
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
