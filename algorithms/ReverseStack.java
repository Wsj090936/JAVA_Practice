package algorithms;
//���õݹ�ʵ��ջ������
/*
 * ʵ�ַ�ʽ�����������ݹ麯����GetStackLast()�ݹ麯��ʵ�ֽ�ջ�е���ײ�Ԫ�ط��س�����Reverse�����ݹ�ʵ��ջ������
 */
import java.util.Stack;

public class ReverseStack {
	public static int GetStackLast(Stack<Integer> S1){//�ݹ鷵��ջ��Ԫ�أ�����Ԫ�ش���ѹ��
		int result = S1.pop();
		if(S1.empty()){//���Ϊ�գ��ͷ���ֵ
			return result;
		}else {
			int last = GetStackLast(S1);//��ʼ�ݹ�
			S1.push(result);
			return last;
		}
		
	}
	public static void Reverse(Stack<Integer> S1){
		if(S1.empty()){
			return;
		}
		int i = GetStackLast(S1);
		Reverse(S1);
		S1.push(i);
	}
	public static void main(String[] args) {
		Stack<Integer> S1 = new Stack<Integer>();//��������
		int[] num = new int[]{1,2,3,4,5,6,7,8,9};
		for(int i = 0;i<num.length;i++){
			S1.push(num[i]);
		}
		Reverse(S1);
		while(!S1.empty()){
			System.out.println(S1.pop());
		}
	}
}
