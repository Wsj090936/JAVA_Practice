package algorithms;
/*
 * 
Given a linked list, remove the nth node from the end of list and return its head.

For example,

   Given linked list: 1->2->3->4->5, and n = 2.

   After removing the second node from the end, the linked list becomes 1->2->3->5.
   ˼·:���и�����һ��������Ҫ������ɾ��������k����㣬���ȣ������Ƚ�k��ͷ��㿪ʼ������һ���α���ptr��ʼʱָ��ͷ�ڵ㣬ÿ����һ��������k��һ��ֱ������������
   Ȼ���ж�k��ֵ�����kΪ0����ôҪɾ���ľ���ͷ�ڵ㣬���k����0����ôҪɾ���Ľ�㲻���ڣ����kС��0������ptrָ��ͷ�ڵ��ͷ��ʼ����������ptrÿ�ƶ�һ�Σ���k��
   ֵ��һ����kΪ0��ʱ��ֹͣ�ƶ������ʱptr���ڵ�λ�þ���Ҫ��ɾ���Ľ���ǰһ����㡣
 */
public class RemoveNthNodeFromEndofList_19 {
	public ListNode1 removeNthFromEnd(ListNode1 head, int k) {
		if(head == null || k <1){
			return null;
		}
		ListNode1 ptr = head;//�α���
		ListNode1 e = null;//�����汻ɾ���Ľ��
		while(ptr != null){
			--k;
			ptr = ptr.next;
		}
		if(k == 0){//k==0ʱɾ��ͷ�ڵ�
			e = head;
			head = head.next;
			return head;
		}else if(k > 0){//k>0��ʾҪɾ���Ľ�㲻����
			return head;
		}else{
			ptr = head;
			while(++k != 0){
				ptr = ptr.next;
			}
			e = ptr.next;
			ptr.next = ptr.next.next;
		}
		return head;
    }
}

class ListNode1 {
     int val;
     ListNode1 next;
     ListNode1(int x) { val = x; }
 }
