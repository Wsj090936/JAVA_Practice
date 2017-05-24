package test2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

public class TestGeneric {
@Test
	public void TestGeneric1(){
	List<Integer> A = new ArrayList<Integer>();
	A.add(55);
	A.add(66);
	A.add(77);
//	for(Integer each:A)
//	{
//		System.out.println(each);
//	}
	Iterator<Integer> i = A.iterator();
	while(i.hasNext())
	{
		System.out.println(i.next());
	} 
	//Map中泛型的使用
	Map<String,Integer> M = new HashMap<>();
	M.put("MM", 1001);
	M.put("GG", 1004);
	M.put("GG", 1003);
	Set<Map.Entry<String,Integer>> a = M.entrySet();
	for(Map.Entry<String, Integer> each:a)
	{
		System.out.println(each);
	}
}
}


