package algorithms;
/*
 * �ڵ��������˫������ɾ�������ص�����K���ڵ�
 * 	�ֱ�ʵ������������һ������ɾ���������е�����K���ڵ㣬��һ������ɾ��˫�����е�����K���ڵ�
 * 	|----------Ҫ�����������ΪN��ʱ�临�ӶȴﵽO(N),����ռ临�ӶȴﵽO(1)
 * ***********************************************************************************************
 * ����˼·:
 * 		����Ҫɾ��������k����㣬�����Ƚ����жϣ���ͷ��㿪ʼ������ÿ����һ�����kֵ�ͼ�һ������β��ʱ���鿴kֵ����kֵΪ0��
 * ��Ҫɾ���Ľ��Ϊͷ�ڵ㣬��kֵ�����㣬�����Ҫɾ���Ľ����������ڣ�����kС��0�����ͷ��㿪ʼ�������������ÿ����һ�����K�ͼ�һ��
 * ��kΪ0��ʱ�򣬵�ǰ�ı���λ�þ͸պ�����Ҫɾ���Ľ���ǰһ����㣬Ȼ�󽫵�ǰ����nextָ��next.next����
 */
public class DeleteLastthNode {//ɾ��������ĵ�����K�����
	public static void main(String[] args) {
		List list = new List();
		int[] num = new int[]{1,2,3,4,5,6,7,8,9};
		for(int i = 0;i < num.length;i++){
			list.add(num[i]);
		}
		Node node = DeleteNode(list.head,2);
		System.out.println(node.value);
	}
	public static Node DeleteNode(Node head,int k){
		if(head == null || k<1){//�������Ϊ�ջ���k��ֵС��1���򷵻ؿ�ֵ
			return null;
		}
		Node cur = head;//�����α���
		Node e = null;//������ɾ���Ľ��
		while(cur != null){
			--k;
			cur = cur.next;
		}
		if(k == 0){//���kΪ0������ͷ�ڵ�
			 e = head;
			 head = head.next;
		}else if(k > 0){//k>0ʱ�����ڵ�����k���ļ�
			return null;
		}else if(k < 0){
			cur = head;
			while(++k != 0){
				cur = cur.next;
			}
			e = cur.next;
			cur.next = cur.next.next;//ɾ��������K�����
		}
		return e;
	}
	public doubleNode DeleteDoubleNode(int k){//ɾ��˫����ĵ�����K�����
		return null;
	}
}
class Node1{//�����
	public int value;
	public Node1 next;
	Node1(int value){
		this.value = value;
	}
}
class doubleNode{
	
}
class List1{//������
	public Node1 head;
	public Node1 node;
	List1(){
		head = node = null;
	}
	public boolean isEmpty(){
		return head == null;
	}
	public void add(int value){
		if(!isEmpty()){
			node.next = new Node1(value);
			node = node.next;
		}else{
			node = new Node1(value);
			head = node;
		}
	}
}

