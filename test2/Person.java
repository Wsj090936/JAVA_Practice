package test2;

public class Person{
	String name;
	int age;
	Person(String name,int age)
	{
		this.name = name;
		this.age = age;
	}
	public String toString(){//��дtoString����
		return ("["+name+","+age+"]");
	}
}