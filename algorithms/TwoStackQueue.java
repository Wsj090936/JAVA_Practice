package algorithms;

import java.util.Stack;

//��������ջʵ�ֶ��еĻ������� add,poll,peek
/*
 * ����ʵ�ֵ�ԭ������������ջStackpush��Stackpop��Stackpush��������ѹ�룬
 * ����Ҫ�����е�ʱ�򣬽�Stackpush�е�ջ��Ԫ��ȫ�����뵽Stackpop�У�
 * �������֮ǰStackpop�Ѿ���Ԫ���ˣ��Ͳ���Ҫ�����ˣ�ֱ����Stackpop�������ɣ�
 * 
 */
public class TwoStackQueue {
public static void main(String[] args) {
	StackQueue S1 = new StackQueue();
	int[] num = new int[]{1,2,3,4,5};//��������
	for(int i = 0;i<num.length;i++){
		S1.add(num[i]);
	}
	while(true){
		System.out.println(S1.poll());
	}
}
}
class StackQueue{
	Stack<Integer> Stackpush;
	Stack<Integer> Stackpop;
	StackQueue(){
		Stackpush = new Stack<Integer>();
		Stackpop = new Stack<Integer>();
	}
	public void add(int data){//�����
		Stackpush.push(data);
	}
	public int poll(){//������
		if(Stackpush.empty()&&Stackpop.empty()){
			throw new RuntimeException("����Ϊ�գ�");
		}else if(Stackpop.isEmpty()){//���StackpopΪ�գ��Ϳ��������������һ��Ԫ�أ�������������Ϊ�գ���ֱ�ӵ���
			while(!Stackpush.empty()){
				Stackpop.push(Stackpush.pop());
			}
		}
		return Stackpop.pop();
	}
	public int peek(){
		if(Stackpush.empty()&&Stackpop.empty()){
			throw new RuntimeException("����Ϊ��");
		}else if(Stackpop.empty()){//���Stackpop��û��Ԫ�أ������ϴ�Stackpush�е���һ��
			while(!Stackpush.empty()){
				Stackpop.push(Stackpush.pop());
			}
		}
		return Stackpop.peek();
	}
}