package TestReflection;

public class Animal extends Creater<String>{
	public String name;
	private int age;
	public Animal(){
		super();
	}
	private Animal(String name,int age){
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
