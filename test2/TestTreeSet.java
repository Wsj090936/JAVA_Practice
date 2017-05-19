package test2;

import java.util.Set;
import java.util.TreeSet;

import org.junit.Test;

public class TestTreeSet {
@Test
	public void TreeSetTest1(){
	Set A = new TreeSet();
	A.add(new Man("帅哥",18));
	A.add(new Man("美女",16));
	A.add(new Man("孩子",9));
	A.add(new Man("MM",18));
	for(Object each : A)
	{
		System.out.println(each);
	}

}
}
class Man implements Comparable{
	private String name;
	private Integer age;	
	public Man(String name, Integer age) {
		super();
		this.name = name;
		this.age = age;
	}
	
	public Man() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((age == null) ? 0 : age.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Man other = (Man) obj;
		if (age == null) {
			if (other.age != null)
				return false;
		} else if (!age.equals(other.age))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Man [name=" + name + ", age=" + age + "]";
	}

	@Override
	public int compareTo(Object e) {
		if(e instanceof Man){
			Man P = (Man)e;
			int i = this.age.compareTo(P.age);
			if(i == 0)
			{
				return this.name.compareTo(P.name);//如果年龄相同的话就比较名字是否相同并返回值
			}else{
				return i;
			}
		}
		return 0;
	}	
}