package test2;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

import org.junit.Test;

public class TestSet {
	@Test
	public void TestHashSet1(){
		Woman P1 = new Woman("��Ů",20);
		Woman P2 = new Woman("��Ů",20);
		Set A = new HashSet();
		A.add(123);
		A.add("˧��");
		A.add("С��");
		A.add("С��");
		A.add(P1);
		A.add(P2);
		System.out.println(A.size());
		System.out.println(A);
	}
	@Test
	public void TestLinkedHashSet1(){
		Set A = new LinkedHashSet();
		A.add(123);
		A.add("˧��");
		A.add("С��");
		A.add("MM");
		Iterator iterator = A.iterator();
		while(iterator.hasNext())
		{
			System.out.println(iterator.next());
		}
	}
}
