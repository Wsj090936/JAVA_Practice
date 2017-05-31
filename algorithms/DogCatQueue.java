package algorithms;

import java.util.LinkedList;
import java.util.Queue;

/*
 * è�����Լ����������£�Ҫ��ʵ��һ�ֶ��У�Ҫ������
 * 1���û����Ե���add������cat���dog���ʵ�����������
 * 2���û����Ե���pollAll�����������������е�ʵ�����ս����е��Ⱥ�˳�����ε���
 * 3���û����Ե���pollDog��������������dog���ʵ�����ս����е��Ⱥ�˳�����ε���
 * 4���û����Ե���pollCat��������������cat���ʵ�����ս����е��Ⱥ�˳�����ε���
 * 5���û����Ե���isEmpty���������������Ƿ���dog��cat��ʵ��
 * 6���û����Ե���isDogEmpty���������������Ƿ���dog���ʵ��
 * 7���û����Ե���isCatEmpty���������������Ƿ���cat���ʵ��
 */
class Pet{
	private String type;
	public Pet(String type){
		this.type = type;
	}
	public String getPetType(){
		return this.type;
	}
	@Override
	public String toString() {
		return "Pet [type=" + type + "]";
	}
	
}
class Dog extends Pet{
	public Dog(){
		super("dog");
	}
	
}
class Cat extends Pet{
	public Cat(){
		super("cat");
	}
}
/********************************************************************************************/
class EnterQueue{
	private Pet pet;
	private long count;//���˳��
	public EnterQueue(Pet pet,long count){
		this.pet = pet;
		this.count = count;
	}
	public Pet getPet(){
		return this.pet;
	}
	public long getCount(){
		return this.count;
	}

}
public class DogCatQueue {//è������
	private Queue<EnterQueue> QueueDog;
	private Queue<EnterQueue> QueueCat;
	private long count;
	public DogCatQueue(){//������
		this.QueueDog = new LinkedList<EnterQueue> ();
		this.QueueCat = new LinkedList<EnterQueue> ();
	}
	public void add(Pet pet){
		if(pet.getPetType().equals("dog")){//�ж��Ƿ�Ϊdog
			QueueDog.add(new EnterQueue(pet,this.count++));//ÿ����һ��������count��ֵȻ��++
		}else if(pet.getPetType().equals("cat")){//�ж��Ƿ�Ϊcat
			QueueCat.add(new EnterQueue(pet,this.count++));//ÿ����һ��������count��ֵȻ��++
		}else{
			throw new RuntimeException("���ʹ���");
		}
	}
	public Pet pollAll(){//����������
		if(!this.QueueDog.isEmpty() && !this.QueueCat.isEmpty()){
			if(this.QueueDog.peek().getCount() < this.QueueCat.peek().getCount()){//��������������countֵ�Ƚ�С���Ǹ�
			return this.QueueDog.poll().getPet();
				}else{
						return this.QueueCat.poll().getPet();
					 }
		}else if(!this.QueueDog.isEmpty()){//���������������һ����Ϊ����ִ����һ��
			return this.QueueDog.poll().getPet();
		}else if(!this.QueueCat.isEmpty()){//���������������һ����Ϊ����ִ����һ��
			return this.QueueCat.poll().getPet();
		}else
			throw new RuntimeException("����Ϊ�գ�");
		}
	
	public Pet pollDog(){//˳�򵯳�Dog��
		if(this.QueueDog.isEmpty()){
			throw new RuntimeException("����Ϊ��");
		}else{
			return this.QueueDog.poll().getPet();
		}
	}
	public Pet pollCat(){//˳�򵯳�Cat��
		if(this.QueueCat.isEmpty()){
			throw new RuntimeException("����Ϊ��");
		}else
			return this.QueueCat.poll().getPet();
	}
	public boolean isEmpty(){//�ж϶����Ƿ�Ϊ��
		return this.QueueDog.isEmpty() && this.QueueCat.isEmpty();
	}
	public boolean isDogEmpty(){
		return this.QueueDog.isEmpty();
	}
	public Boolean isCatEmpty(){
		return this.QueueCat.isEmpty();
	}
	public static void main(String[] args) {//���в���
		DogCatQueue P1 = new DogCatQueue();
		P1.add(new Dog());
		P1.add(new Cat());
		P1.add(new Dog());
		P1.add(new Dog());
		P1.add(new Cat());
		P1.add(new Cat());
		for(int i = 1;i<=6;i++){
			System.out.println(i+"--->"+P1.pollAll());
		}
	}
}
