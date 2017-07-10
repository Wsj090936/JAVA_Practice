package algorithms;
/*
 *  you are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

	You may assume the two numbers do not contain any leading zero, except the number 0 itself.
	
	Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
	Output: 7 -> 0 -> 8
 */
public class AddTwoNumbers_2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null && l2 == null){
            return null;
        }
        ListNode ptr = l1;
        ListNode cur = l2;
        ListNode head = new ListNode(0);//�������ͷ�ڵ�
        ListNode node = head;//�α���
        int e = 0;//��������Ľ�����֮��
        int e1 = 0;//��λ���λ�Ľ�λ
        while(ptr != null || cur != null){
            if(ptr != null){
                e = e + ptr.val;
                ptr = ptr.next;
            }
            if(cur != null){
                e = e + cur.val;
                cur = cur.next;
            }
            node.next = new ListNode(e%10);
            e = e/10;
            node = node.next;
        }
        if(e > 0){
            node.next = new ListNode(e);   
        }
        return head.next;
  }
}
