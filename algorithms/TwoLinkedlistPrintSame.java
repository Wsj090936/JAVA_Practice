package algorithms;
/*
 *����������������ı�ͷָ��head1��head2����ӡ��������Ĺ������֣� 
 *
 *�����������������Կ���ֱ���ж�ͷ�ڵ��ֵ����head1����head2��ֵ����head2ָ����һλ������head1ָ����һλ
 */
public class TwoLinkedlistPrintSame {
public static void printSame(Node head1,Node head2){
	while(head1 != null && head2 != null){
		if(head1.value > head2.value){
			head2 = head2.next;
		}else if(head1.value < head2.value){
			head1 = head1.next;
		}else{
			System.out.println(head1.value);
			head1 = head1.next;
			head2 = head2.next;
		}
	}
}
public static void main(String[] args){//��������
	List list1 = new List();
	List list2 = new List();

	int[] num = new int[]{1,2,3,4,5,6,7,8,9};
	int[] num2 = new int[]{3,1,2,4,5,6,7,98,9,4,5,7};
	for(int i = 0;i < num.length;i++){
		list1.add(num[i]);
	}
	for(int i = 0;i < num2.length;i++){//��ָ���쳣
		list2.add(num2[i]);
	}
	printSame(list1.head,list2.head);
}
}
class Node{//����ڵ���
	public int value;
	public Node next;
	Node(int value ){
		this.value = value;
	}
}
class List{//����������
	public Node node,head;
	List(){
		node = head = null;
	}
	public boolean isEmpty(){//ͷ�ڵ�Ϊ�ռ�����Ϊ��
		return head == null;
	}
	public void add(int value){
		if(!isEmpty()){
			node.next = new Node(value);//һ��Ҫ����д��������߼�����Ѫ�Ľ�ѵ��Ӧ���ȳ�ʼ����һ���ڵ�Ȼ�����ƶ�ָ��
			node = node.next;
		}else{
			head = node = new Node(value);
		}
		
	}
}
