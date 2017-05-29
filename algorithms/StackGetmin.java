package algorithms;
/*
 * дһ������getMin()����СջԪ�ص�ջ������ʹ�û���ջ ���Ѷ�С��
 */
import java.util.Stack;

public class StackGetmin {
public static void main(String[] args) {
	MyStack S1 = new MyStack();
	int[] num = new int[]{8,3,5,6,6,2,5,8,2,1,4,1};
	for(int i = 0;i<num.length;i++){
		S1.push(num[i]);
	}
	while(true){
		int value = S1.pop();
		System.out.println("ջ��Ԫ��"+value+"��ջ");
		System.out.println("Ŀǰջ�е���СԪ��Ϊ:"+S1.getMin());
	}
}
}
class MyStack{
	private Stack<Integer> StackData;//����ջ
	private Stack<Integer> StackMin;//��ջ�е�Ԫ����ջ�׵�ջ����С�ݼ�������ʱ��������Ԫ�ش���ջ��������ջ����С�ڣ�����ջ������ȣ���Ҳ��ջ
	public MyStack(){
		this.StackData = new Stack<Integer>();
		this.StackMin = new Stack<Integer>();
	}
	public void push(int data){//��ջ
		if(this.StackMin.isEmpty()){//���StackMinջΪ�գ����۸�����󣬶���ջ
			StackMin.push(data);
		}else if(data <= this.getMin()){//�����ջ��Ԫ�رȵ�ǰջ����С��Ԫ�ػ�С�������StackMinջ��
				StackMin.push(data);
		}
		StackData.push(data);
	}
	public int pop(){//��ջ
		if(StackData.isEmpty()){
			throw new RuntimeException("ջΪ��");
		}
		int value = StackData.pop();//����ջԪ�ش����Զ������value��
		if(value == this.getMin()){//����ջԪ�ص�����СԪ�أ�����СԪ��Ҳ��ջ
			this.StackMin.pop();
		}
		return value;
	}
	public int getMin(){
		if(this.StackMin.isEmpty()){
			throw new RuntimeException("����СֵԪ��");
		}
		return this.StackMin.peek();//ջStackMin��ջ��Ԫ�ؼ�Ϊ��ǰջ�е���СԪ��
	}
}