package algorithms;
/*
 * ��Ŀ:���������ͷhead�ֱ�ʵ�ֵ������˫����ķ�ת��������ͷ�ڵ�
 * Ҫ��:���������ΪN��ʱ�临�Ӷ�Ҫ��ΪO(N),����ռ临�Ӷ�ΪO(1)
 * *******************************************************************
 * ˼·:
 * 			���ڸ�����ͷ���head,Ҫ������ȥ��תһ��������ʱ�临�Ӷ�ΪO(N)�����Կ���������:���ǿ��Խ���ת�����Ǵ���һ��������Ĺ��̶��������α��㣬
 * һ��Ϊptr��һ��Ϊnext��ptrΪ�½���ͷ��㣬next�տ�ʼָ��������ͷ�ڵ㣬ÿ�η�ת�����ֻ��Ҫ���������ͷ���ָ���������ͷ�ڵ㣬Ȼ���������ͷ��
 * ������Ʊ�Ϊ�ող�����½�㣬�������ͷ�ڵ��Ϊ�ո�ɾ���Ľ�����һ�����ͺ��ˣ�������뿴����
 */
public class ReverseLinkList {
public static void main(String[] args) {//��������
	List4 list = new List4();
	int[] num = new int[]{1,2,3,4,5,6,7,8,9};
	for(int each:num){
		list.add(each);
	}
	System.out.println("ԭ����Ϊ:");
	Node4 cur = list.head;
	for(int i = 0; i<num.length;i++){
		System.out.print(cur.value);
		cur = cur.next;
	}
	System.out.println();
	Node4 cur1 = reverseList(list.head);
	System.out.println("��ת������Ϊ:");
	for(int i = 0; i<num.length;i++){
		System.out.print(cur1.value);
		cur1 = cur1.next;
	}
	/*
	 * ���н��:ԭ����Ϊ:
				123456789
				��ת������Ϊ:
				987654321
	 * 
	 */
}
	public static Node4 reverseList(Node4 head){//��ת����
		Node4 ptr = null;//ÿ��ѭ��һ�ζ�λ�ڱ�ͷ���뵱���������ͷ�ڵ�
		Node4 next = null;//�α��㣬ÿѭ��һ�ζ�λ��ԭ���ı�ͷ
		while(head != null){
			next = head.next;
			head.next = ptr;
			ptr = head;
			head = next;
		}
		return ptr;
	}
}
class Node4{
	int value;
	Node4 next;
	Node4(int value){
		this.value = value;
	}
}
class List4{//������
	Node4 head,node;
	List4(){
		head = node = null;
	}
	public boolean isEmpty(){
		return head == null;
	}
	public void add(int value){
		if(!isEmpty()){
			node.next = new Node4(value);
			node = node.next;
		}else{
			head = node = new Node4(value);
		}
	}
}