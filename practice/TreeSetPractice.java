package practice;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

import org.junit.Test;

public class TreeSetPractice {
	@Test//定制排序
	public void test2(){
		Comparator A = new Comparator(){

			@Override
			public int compare(Object e1, Object e2) {
				if(e1 instanceof Employee1 && e2 instanceof Employee1)
				{
					Employee1 P1 = (Employee1)e1;
					Employee1 P2 = (Employee1)e2;
					Mydate Birth1 = P1.getBirthday();
					Mydate Birth2 = P2.getBirthday();
					if(Birth1.getYear() != Birth2.getYear())
					{
						return Birth1.getYear() - Birth2.getYear();
					}else if(Birth1.getMonth() != Birth2.getMonth())
						{
						  	return Birth1.getMonth() - Birth2.getMonth();
						}else if(Birth1.getDay() != Birth2.getDay())
							{
								return Birth1.getDay() - Birth2.getDay();
							}
				}
				return 0;
			}
			
		};
		TreeSet Singer2 = new TreeSet(A);
		Employee1 P1 = new Employee1("李荣浩",32,new Mydate(1985,7,11));
		Employee1 P2 = new Employee1("薛之谦",34,new Mydate(1983,7,17));
		Employee1 P3 = new Employee1("刘德华",56,new Mydate(1961,9,27));
		Employee1 P4 = new Employee1("周杰伦",38,new Mydate(1979,1,8));
		Employee1 P5 = new Employee1("林俊杰",36,new Mydate(1981,3,27));
		Singer2.add(P1);
		Singer2.add(P2);
		Singer2.add(P3);
		Singer2.add(P4);
		Singer2.add(P5);
		for(Object each:Singer2)
		{
			System.out.println(each);
		}
		
		
	}
	@Test
	public void test1(){
	Employee P1 = new Employee("李荣浩",32,new Mydate(1985,7,11));
	Employee P2 = new Employee("薛之谦",34,new Mydate(1983,7,17));
	Employee P3 = new Employee("刘德华",56,new Mydate(1961,9,27));
	Employee P4 = new Employee("周杰伦",38,new Mydate(1979,1,8));
	Employee P5 = new Employee("林俊杰",36,new Mydate(1981,3,27));
	Set Singer = new TreeSet();
	Singer.add(P1);
	Singer.add(P2);
	Singer.add(P3);
	Singer.add(P4);
	Singer.add(P5);
	Iterator iterator = Singer.iterator();
	while(iterator.hasNext())//按名字排序(自然排序)
	{
		System.out.println(iterator.next());
	}
	}

}


