package algorithms;
/*
 * Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.
 * 
 * 
 * �ϲ���������������������Ϊ���б��ء����б�Ӧ��ͨ��ƴ��ǰ�����б�Ľڵ������
 * 
 * ����:1->2->4->5->6->null
 *      1->3->5->7->null
 * �ϲ�����Ϊ: 1->1->2->3->4->5->5->6->7
 * 
 * ˼·: ���и�������������������list1��list2��ͷ�ڵ㣬��������ƴ������������һ���µ��������ȣ���ȷ���������ͷ�ڵ�head��
 * ȡ����ԭ������ͷ�ڵ��С���Ǹ������Ϊ�������ͷ�ڵ㣬Ȼ���������α���ptr1��ptr2���ֱ��ͷ����list1��list2
 * ������ʽ���£�ptr1��ptr2�ֱ��list1��list2��ͷ�ڵ���������ж�ptr1��ptr2��ֵ���ҳ������н�С���Ǹ�������list1��ͷ�ڵ��ֵС��
 * list2��ͷ�ڵ��ֵ��Ȼ����һ������pre��ָ��ptr1��Ȼ��ptr1ָ������һ����㣬Ȼ��ѭ���������´αȽ�ʱ��ptr1��ֵ����ptr2��ֵ������һ����
 * �Ľ��nextָ��ptr2����һ����㣬Ȼ��pre.nextָ��ptr2��ptr2.nextָ��ptr1,������һ��ƴ�ӵĹ��̾�����ˣ�Ȼ��preָ��ո�ƴ�ӹ�ȥ��
 * ��㣬����ptr2ָ����һ����㼴ptr2 = next;���ѭ���������ܻ���һ�������ȱ����꣬��δ�������������ֱ��ƴ�ӵ�pre�󼴿ɡ�
 * 
 */
public class MergeTwoSortedLists_21 {
	public static void main(String[] args) {
		List7 list = new List7();
		List7 list1 = new List7();
		int[] num = new int[]{1,2,3,5,7,8};
		int[] num1 = new int[]{1,3,5,9};
		for(int each:num){
			list.add(each);
		}
		for(int each:num1){
			list1.add(each);
		}
		Node7 cur1 = mergeTwoLists(list.head,list1.head);
		while(cur1 != null){
			System.out.println(cur1.value);
			cur1 = cur1.next;
		}
	}
	public static Node7 mergeTwoLists(Node7 l1,Node7 l2){
        if(l1 == null || l2 == null){
            return l1 != null ? l1 : l2;
        }
		Node7 head = l1.value < l2.value ? l1 : l2;//�������ͷ�ڵ�
		Node7 ptr1 = head == l1 ? l1 : l2;//�α���
		Node7 ptr2 = head == l1 ? l2 : l1;//�α���
		Node7 pre = null;//�ý��ָ�������α����н�С���Ǹ����
		Node7 next = null;
		while(ptr1 != null && ptr2 != null){
			if(ptr1.value <= ptr2.value){
				pre = ptr1;
				ptr1 = ptr1.next;
			}else{//��ʼƴ��
				next = ptr2.next;
				pre.next = ptr2;
				ptr2.next = ptr1;
				pre = ptr2;
				ptr2 = next;
			}
			
		}
		pre.next = ptr1 == null ? ptr2 : ptr1;
		return head;
	}
}
class Node7{
	int value;
	Node7 next;
	Node7(int value){
		this.value = value;
	}
}
class List7{//������
	Node7 head,node;
	List7(){
		head = node = null;
	}
	public boolean isEmpty(){
		return head == null;
	}
	public void add(int value){
		if(!isEmpty()){
			node.next = new Node7(value);
			node = node.next;
		}else{
			head = node = new Node7(value);
		}
	}
}