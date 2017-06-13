package algorithms;
/*
 * ɾ��������������м����a/b���Ľ��
 * ��Ŀһ�����������ͷ�ڵ�head��ʵ��ɾ��������м���ĺ���
 * �磺
 * ��ɾ���κν��
 * 1->2 ɾ�����1
 * 1->2->3 ɾ�����2
 * 1->2->3->4 ɾ�����2
 * 1->2->3->4->5 ɾ�����3
 * ��Ŀ�������������ͷ�ڵ�head������a��b��ʵ��ɾ��λ��a/b�����ĺ���
 * ���磺
 * ����1->2->3->4->5������a/b��ֵΪr
 * ���r����0����ɾ���κν��
 * ���r������(0,1/5]�ϣ�ɾ�����1
 * ���r������(1/5,2/5]�ϣ�ɾ�����2
 * ���r������(2/5,3/5]�ϣ�ɾ�����3
 * ���r������(3/5,4/5]�ϣ�ɾ�����4
 * ���r������(4/5,1]�ϣ�ɾ�����5
 * ���r>1 ��ɾ���κν��
 * **************************************************************************
 * ����˼·��
 * ��Ŀһ��
 * 		��Ŀһ�и��˳�ͷ�ڵ㣬ȥɾ���м��㣬���Կ��Զ������������α���slow��fast����ͷ���head�ĵ�ַ����slow��
 * Ȼ��head.next.next�ĵ�ַ����fast(��Ϊ��ɾ���м��㣬�����ǲ��ң����Ϊ���ң��ͽ�head�ĵ�ַ������),Ȼ�����ѭ����
 * ÿѭ��һ��slow�����ǰ��һλ��fast�����ǰ����λ����fast.next.next����fast.nextΪ��ʱ��ѭ����������ʱslow��λ�þ�λ���м����ǰһ����㣬
 * �������Ϳ��Խ���ɾ��������
 * ��Ŀ����
 * 		��Ŀ����Ҫ��ɾ��λ��a/bλ�õĽ�㣬���Դ���Ŀ�������п�������a/bΪ��������ʱ�򣬾ٸ����ӣ���a/bΪ0.1��ʱ�򣬾�Ҫɾ����һ������ˣ�
 * ��ζ��0.1�����ת��Ϊint��ʱ����ȡ���ˣ����Կ����ܽ��һ����ʽ double r = ((double)(a*n)/(double)b) ������nΪ�����ȣ��ù�ʽ�����ֵr��������ȡ������
 * ��������Ϊ��ɾ���Ľ�㣬����ֻ��Ҫ���r����������ȡ�������ܹ��ҵ���ɾ���Ľ���ˣ�
 */
public class RemoveMidOrByRatioNode {
	public static void main(String[] args) {//��������
		List3 list = new List3();
		int[] num = new int[]{1,2,3,4,5,6,7,8,9};
		for(int i = 0 ;i<num.length;i++){
			list.add(num[i]);
		}
//		Node3 cur = list.head;
//		while(cur != null){
//			System.out.println(cur.value);
//			cur = cur.next;
//		}
		Node3 e = null;
		e = deletemid(list.head);
		System.out.println(e.value);
		System.out.println(deleteByRatio(list.head,3,9).value);//������Ϊ3
		
	}
//------------------�㷨����-------------------------
	public static Node3 deletemid(Node3 head){
		Node3 e = null;//�����汻ɾ���Ľ��
		Node3 slow = head;//��ָ��
		Node3 fast = head.next.next;//��ָ��
		if(head == null || head.next == null){//������Ϊ�ջ�ֻ��һ������ʱ��ֱ�ӷ���
			return head;
		}
		if(head.next.next == null){//�������еĽ����Ϊ2ʱ������ͷ�ڵ�
			e = head;
			head = head.next;
		}else{
		while(fast.next != null && fast.next.next != null){//��fast.next.next����fast.nextΪ�յ�ʱ��slow�պ�ָ���м����ǰһ�����
			slow = slow.next;
			fast = fast.next.next;
		}
		e = slow.next;
		slow.next = slow.next.next;//ɾ���м���
		}
		return e;
	}
	public static Node3 deleteByRatio(Node3 head,int a,int b){//ɾ��λ��a/b�Ľ��
		Node3 e = null;//�����汻ɾ���Ľ��
		if(a>b || a<1){
			System.out.println("�����ֵ����");
			return null;
		}
		int n = 0;//������¼������
		Node3 cur = head;//�α���
		while(cur != null){//��ȡ������
			cur = cur.next;
			n++;
		}
		n = (int)Math.ceil((double)(a*n)/(double)b);//����ȡ������ʾɾ����n�����
		if(n == 1){//ɾ����һ�����ֱ�ӷ���ͷ�ڵ�
			e = head;
			head = head.next;
		}else if(n > 1){
			cur = head;
			while(--n != 1){//���α�λ��a/b���Ľ���ǰһ�����ʱ��ѭ����ֹ
				cur = cur.next;
			}
			e = cur.next;
			cur.next = cur.next.next;
		}
		return e;
		
	}
}
class Node3{//�����
	public int value;
	public Node3 next;
	Node3(int value){
		this.value = value;
	}
}
class List3{//��������
	Node3 head,node;
	public boolean isEmpty(){
		return head == null;
	}
	public void add(int value){
		if(!isEmpty()){
			node.next = new Node3(value);
			node = node.next;
		}else{
			node = new Node3(value);
			head = node;
		}
	}
}
