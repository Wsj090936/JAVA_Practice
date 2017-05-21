package test2;

import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import org.junit.Test;

public class TestHashMap {
@Test
	public void HashMapTest1(){
	Map A = new HashMap();
	Map B = new HashMap();
	A.put("A", 123);
	A.put("C", 321);
	A.put("R", 345);
	A.put("F", 123);
	A.put(new Woman("美女",18), 456);
	A.put(new Woman("美女",18), 654);
	B = A;
	System.out.println(A);
	System.out.println(A.equals(B));
	
}
@Test 
public void TestHashMap2(){
	Map A = new HashMap();
	A.put("A", 123);
	A.put("C", 321);
	A.put("R", 345);
	A.put("F", 123);
	Set set = A.keySet();
	Collection col =A.values();
	//遍历key集
	for(Object each:set){
	System.out.println(each);
	}
	//遍历value集
	for(Object each:col)
	{
		System.out.println(each);
	}
	//遍历key-value集（entry）
		//方法一  利用Map的get(Object key)方法实现遍历
	for(Object each:set)
	{
		System.out.println(each+"--->"+A.get(each));
	}
		//方法二  利用entrySet()方法遍历
	Set set1 = A.entrySet();
	for(Object each:set1)
	{
		Map.Entry obj = (Map.Entry)each;
		System.out.println(obj);
	}
}
@Test//TreeMap的遍历
public void TestTreeMap(){
	//方法一  自然排序（先比较年龄，如果年龄相同的话就比较名字是否相同）
	TreeMap A = new TreeMap();
	A.put(new Man("AA",29), 0001);
	A.put(new Man("CC",29), 0004);
	A.put(new Man("FF",19), 0005);
	A.put(new Man("RR",17), 0003);
	Set set = A.keySet();
	for(Object each:set)
	{
		System.out.println(each+"--->"+A.get(each));
	}
	
}
@Test
//方法二  定制排序 //按照Student中的ID排，id一样再按照name进行排序
public void TestTreeMap1(){
	Comparator A = new Comparator(){
		@Override
		public int compare(Object e1, Object e2) {
			if(e1 instanceof Student && e2 instanceof Student)
			{
				Student P1 = (Student)e1;
				Student P2 = (Student)e2;
				int i = P1.getId().compareTo(P2.getId());
				if(i == 0)
				{
					return P1.getName().compareTo(P2.getName());
				}
				return i;
			}
			return 0;
		}	
	};
	TreeMap B = new TreeMap(A);
	B.put(new Student("AA",29), 0001);
	B.put(new Student("CC",29), 0004);
	B.put(new Student("FF",19), 0005);
	B.put(new Student("RR",17), 0003);
	Set set = B.keySet();
	for(Object each:set)
	{
		System.out.println(each+"--->"+B.get(each));
	}
}
}
