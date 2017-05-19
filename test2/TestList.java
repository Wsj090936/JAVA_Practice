package test2;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
public class TestList {
	@Test
	public void ListTest1(){
		Person P = new Person("美女",20);
		List A = new ArrayList();
		List B = new ArrayList();
		A.add(123);
		A.add("帅哥");
		A.add(P);
		B.addAll(A);//调用Collection中的addAll()方法
		//1：void add(int Index,Object e)
		A.add(2, "小孩");
		//2：boolean addAll(int Index,Collection e)
		A.addAll(3, B);
		System.out.println("插入元素后的集合为：");
		for(Object each:A)//打印插入元素后的集合
		{
			System.out.println(each);
		}
		//3:Object get(int Index)
		System.out.println("方法三所得元素的值为："+A.get(2));
		//4:Object remove(int Index)
		System.out.println("方法四被删除的元素为："+A.remove(2));
		//5：Object set(int Index , Object e)
		System.out.println("方法五被替换的元素为："+A.set(0, 456));
		System.out.println("现在集合的元素如下：");
		for(Object each:A)//打印替换和删除元素后的集合
		{
			System.out.println(each);
		}
		//6：int indexOf(Object e)
		//7：int lastIndexOf(Object e)
		System.out.println("方法六该元素第一次出现的位置为："+A.indexOf("帅哥"));
		System.out.println("方法七该元素最后一次出现的位置为："+A.lastIndexOf("帅哥"));
		//8:List subList(int fromIndex,int toIndex)
		List C = A.subList(3, 5);
		System.out.println("方法八所得的集合为");
		for(Object each:C)//打印集合C
		{
			System.out.println(each);
		}
		
	}
	
}

