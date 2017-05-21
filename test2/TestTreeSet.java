package test2;

import java.util.Set;
import java.util.TreeSet;

import org.junit.Test;

public class TestTreeSet {
@Test
	public void TreeSetTest1(){
	Set A = new TreeSet();
	A.add(new Man("Ë§¸ç",18));
	A.add(new Man("ÃÀÅ®",16));
	A.add(new Man("º¢×Ó",9));
	A.add(new Man("MM",18));
	for(Object each : A)
	{
		System.out.println(each);
	}

}
}
