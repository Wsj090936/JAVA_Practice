package algorithms;

import java.util.Iterator;

/*
 * ��Ŀ: ��ת���ֵ�������
 * 		����һ�����������ͷ�ڵ�head���Լ���������from��to���ڵ��������ϰɵ�from����㵽��to�������һ���ֽ��з�ת
 * ����:
 * 		1->2->3->4->5->null,from = 2�� to = 4
 * 		�������Ϊ:1->4->2->3->5->null
 * 		1->2->3->null,from = 1, to = 3
 * 		�������Ϊ:3->2->1->null 
 * Ҫ��:
 * 		1�����������ΪN��ʱ�临�Ӷ�Ҫ��ΪO(N)������ռ临�Ӷ�Ҫ��ΪO(1).
 * 		2�����������1<=from<=to<=N�����õ���
 * *********************************************************************************************************
 * ˼·:
 * 		���ж���Ҫ��ת��λ�õ���ֵ�Բ��ԣ�������ԣ�ֱ�ӷ���ͷ�ڵ㣬�����ȷ�������ҵ���from-1�������to+1������λ�ã�Ȼ�����α������Ž���������
 * �ķ�ת��ÿѭ��һ���α����ǰ��һ����㣬����α����ƶ�����to+1������λ�þ�ֹͣѭ������ʾ��ת����
 */
public class ReverLinkListPart {
	public static void main(String[] args) {//��������
		List5 list = new List5();
		int[] num = new int[]{1,2,3,4,5,6,7,8,9};
		for(int i = 0;i < num.length ; i++){
			list.add(num[i]);
		}
		Node5 head = reverse(list.head,2,4);
		
		while( head != null){
			System.out.print(head.value);
			head = head.next;
		}
	}

	public static Node5 reverse(Node5 head , int from , int to){
		int len = 0;
		Node5 node1 = head;//�µ�ͷ�ڵ�
		Node5 fpre = null;//fromλ�ý���ǰһ���
		Node5 tpos = null;//toλ�ý��ĺ�һ�ڵ�
		while(node1 != null){//��λfpre��tpos��λ��
			len++;
			fpre = len == from - 1 ? node1 : fpre;
			tpos = len == to +1 ? node1 : tpos;
			node1 = node1.next;
		}
		if(from > to || from < 1 || to > len){//��������������  �򲻷�ת
			System.out.println("����ķ�Χ����");
			return head;
		}
		node1 = fpre == null ? head : fpre.next;
		Node5 node2 = node1.next;//�α���
		node1.next = tpos;
		Node5 next = null;//�Ž��
		while(node2 != tpos){//��ʼ��ת
			next = node2.next;
			node2.next = node1;
			node1 = node2;
			node2 = next;
		}
		if(fpre != null){//�����ת���Ǵ�ͷ�ڵ㿪ʼ��  �ͷ���ԭ���Ľ��
			fpre.next = node1;
			return head;
		}
		return node1;//�����ת�Ǵ�ͷ��㿪ʼ��  �ͷ����µ�ͷ�ڵ�node1
	}
}
class Node5{
	int value;
	Node5 next;
	Node5(int value){
		this.value = value;
	}
}
class List5{
	Node5 head,node;
	public boolean isEmpty(){
		return head == null;
	}
	public void add(int value){
		if(!isEmpty()){
			node.next = new Node5(value);
			node = node.next;
		}else{
			head = node = new Node5(value);
		}
	}
}