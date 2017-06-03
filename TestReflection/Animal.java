package TestReflection;

public class Animal {
	public String name;
	private int age;
	Animal(){
		super();
	}
	Animal(String name,int age){
		this.name = name;
		this.age = age;
	}
	public void show(){
		System.out.println("我是一只动物");
	}
	public void display(String type){
		System.out.println("我是"+type);
	}
	@Override
	public String toString() {
		return "Animal [name=" + name + ", age=" + age + "]";
	}
	
}
