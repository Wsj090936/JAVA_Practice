package algorithms;
/*
 * Reverse a singly linked list
 * 
 * ˼·  ��ĿҪ��һ��������ת�����Խ�����ķ�ת���̿���һ��������Ĵ������̣����ȣ���Ŀ�������������ͷ�ڵ㣬���ǿ����������ͷ�ڵ㣬
 * �ֽ���һ���α���next��һ��ֵΪnull�Ŀս��ptr��Ȼ����з�ת���������ǿ��Խ�ptr����������ı�ͷ��������ÿ�β�����ʱ��������next�α���
 * ָ��������ͷ����һ����㣬Ȼ�󽫾�����ı�ͷָ��ptr�����֮���ٽ�ptrָ�������ı�ͷ������ٽ�ָ��������ͷ�Ľ��ָ��next��㡣���ѭ����
 * ����ķ�ת������ˡ�
 * 
 * 
 * 
 */
public class ReverseLinkedList_206 {
	public static void main(String[] args) {//����
		List6 list = new List6();
		int[] num = new int[]{1,2,3,4,5,6,7,8,9};
		for(int i = 0;i < num.length ; i++){
			list.add(num[i]);
		}
		Node6 head = reverselist(list.head);
		
		while( head != null){
			System.out.print(head.value);
			head = head.next;
		}
		/**
		 * ԭ���� 123456789
		 * ������ 987654321
		 */
	}
	public static Node6 reverselist(Node6 head){
		Node6 ptr = null;//�������ͷ�ڵ�
		Node6 next = null;//�α���
		while(head != null){
			next = head.next;
			head.next = ptr;
			ptr = head;
			head = next;
		}
		return ptr;
		
	}
}
class Node6{//�����
	int value;
	Node6 next;
	Node6(int value){
		this.value = value;
	}
}
class List6{//������
	Node6 head,node;
	List6(){
		head = node = null;
	}
	public boolean isEmpty(){
		return head == null;
	}
	public void add(int value){
		if(!isEmpty()){
			node.next = new Node6(value);
			node = node.next;
		}else
			head = node = new Node6(value);
	} 
}