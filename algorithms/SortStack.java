package algorithms;

import java.util.Stack;

/*
 * һ��ջ�е�Ԫ������Ϊ���ͣ������뽫��ջ�Ӷ����װ��Ӵ�С��˳������
 * ֻ��������һ��ջ�����������µı��������ǲ����ö�������ݽṹ
 * 
 * -----------------------------------------------------------------
 * ����˼·����Ȼֻ��ʹ�ö����һ��ջ����ô�ͽ�ԭջ�е����ݴ�ջ����ʼһ��һ�����븨��ջ�У�
 * �����������ݱȸ���ջ��ջ��С������ȵĻ������룬��֮���򲻵��룬
 * ��������ջ��Ԫ�ش�ջ����ʼһ��һ������ԭջ��(��Ϊ�Ѿ��ź����ˣ����ص��Ļ�ȥʱ����)ֱ������ջջ��Ԫ�ش��ڻ���ڵ�ǰ��Ҫ�����Ԫ��
 * ��ԭջΪ�յ�ʱ�򣬸���ջ�е�Ԫ�ص�˳��Ӷ������ǰ���С�����ŵģ���ʱ�ٽ���Ԫ��һ��һ������ԭջ�У����������ĿҪ��
 */
public class SortStack {
public static void Reverse(Stack<Integer> stackSort){
	Stack<Integer> stackHelp = new Stack<Integer>();//���븨��ջ
	while(!stackSort.isEmpty()){//��ԭջ�е�Ԫ�ص��븨��ջֱ��Ϊ��
		int item = stackSort.pop();//��ջ������
		//������ջ��Ϊ�գ����жϸ���ջջ���Ƿ��item�󣬴���ߵ�������룬С�򽫸���ջ�е�Ԫ��һ��һ������ԭջ��ֱ��item��Ȼ�С�ڸ���ջ��
		while(!stackHelp.isEmpty() && item > stackHelp.peek()){
			stackSort.push(stackHelp.pop());
		}
		stackHelp.push(item);
	}
	while(!stackHelp.isEmpty()){//���ź����ջ�е�Ԫ��һ��һ������ԭջ��
		stackSort.push(stackHelp.pop());
	}
	
 }
public static void main(String[] args) {//��������
	Stack<Integer> S1 = new Stack<Integer>();
	int[] num = new int[]{9,8,7,6,5,4,3,2,1};
	for(int i = 0;i < num.length;i++){
		S1.push(num[i]);
	}
	Reverse(S1);
	while(!S1.isEmpty()){
		System.out.println(S1.pop());
	}
}
}