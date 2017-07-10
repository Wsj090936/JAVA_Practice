package algorithms;
/*
 * Given a linked list, swap every two adjacent nodes and return its head.

	For example,
	Given 1->2->3->4, you should return the list as 2->1->4->3.
	
	Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.

	˼·:��ĿҪ�����Ƿ�ת���ڵ�������㣬�������ǿ��Զ��������α��㣬����ָ��������ָ��Ҫ����ת���ֵĵ�һ�����͵ڶ�����㣬
	��һ��ָ��ָ�򱻷�ת���β��㣬��������һ�η�ת�������������
 */
public class SwapNodesInPairs_24 {
	public static void main(String[] args) {
		List8 list1 = new List8();
		int[] num = new int[]{1,2,3};
		for(int i = 0;i < num.length;i++){
			list1.add(num[i]);
		}
		Node8 A = swapPairs(list1.head);
		while(A != null){
			System.out.print(A.value+",");
			A = A.next;
		}
	}
	public static Node8 swapPairs(Node8 head) {
        if(head == null){
            return null;
        }
        Node8 ptr = head;//����ת���ֵĵ�һ�����
        Node8 cur = ptr.next;//����ת���ֵĵڶ������
        Node8 front = null;//����ת�������β���
        if(cur == null){
            return head;
        }else{
            head = cur;
            while(true){//��ʼ��ת
                    front = ptr;
                    ptr.next = cur.next;
                    cur.next = ptr;
                    if(ptr.next == null){
                    	return head;
                    }
                    ptr = ptr.next;
                    if(ptr.next == null){
                    	return head;
                    }
                    cur = ptr.next;                    	
                    front.next = cur;      
            }  
        }
    }
}
class Node8{//����ڵ���
	public int value;
	public Node8 next;
	Node8(int value ){
		this.value = value;
	}
}
class List8{//����������
	public Node8 node,head;
	List8(){
		node = head = null;
	}
	public boolean isEmpty(){//ͷ�ڵ�Ϊ�ռ�����Ϊ��
		return head == null;
	}
	public void add(int value){
		if(!isEmpty()){
			node.next = new Node8(value);//һ��Ҫ����д��������߼�����Ѫ�Ľ�ѵ��Ӧ���ȳ�ʼ����һ���ڵ�Ȼ�����ƶ�ָ��
			node = node.next;
		}else{
			head = node = new Node8(value);
		}
		
	}
}