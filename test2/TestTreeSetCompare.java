package test2;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

import org.junit.Test;

public class TestTreeSetCompare {
@Test
	public void TestTree2(){
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
	Set B = new TreeSet(A);
	B.add(new Student("张三",1000));
	B.add(new Student("李四",1004));
	B.add(new Student("王五",1007));
	B.add(new Student("赵六",1002));
	B.add(new Student("吴三",1100));
	Iterator iterator = B.iterator();
	while(iterator.hasNext())
	{
		System.out.println(iterator.next());
	}
}
}
