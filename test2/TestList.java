package test2;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
public class TestList {
	@Test
	public void ListTest1(){
		Person P = new Person("��Ů",20);
		List A = new ArrayList();
		List B = new ArrayList();
		A.add(123);
		A.add("˧��");
		A.add(P);
		B.addAll(A);//����Collection�е�addAll()����
		//1��void add(int Index,Object e)
		A.add(2, "С��");
		//2��boolean addAll(int Index,Collection e)
		A.addAll(3, B);
		System.out.println("����Ԫ�غ�ļ���Ϊ��");
		for(Object each:A)//��ӡ����Ԫ�غ�ļ���
		{
			System.out.println(each);
		}
		//3:Object get(int Index)
		System.out.println("����������Ԫ�ص�ֵΪ��"+A.get(2));
		//4:Object remove(int Index)
		System.out.println("�����ı�ɾ����Ԫ��Ϊ��"+A.remove(2));
		//5��Object set(int Index , Object e)
		System.out.println("�����屻�滻��Ԫ��Ϊ��"+A.set(0, 456));
		System.out.println("���ڼ��ϵ�Ԫ�����£�");
		for(Object each:A)//��ӡ�滻��ɾ��Ԫ�غ�ļ���
		{
			System.out.println(each);
		}
		//6��int indexOf(Object e)
		//7��int lastIndexOf(Object e)
		System.out.println("��������Ԫ�ص�һ�γ��ֵ�λ��Ϊ��"+A.indexOf("˧��"));
		System.out.println("�����߸�Ԫ�����һ�γ��ֵ�λ��Ϊ��"+A.lastIndexOf("˧��"));
		//8:List subList(int fromIndex,int toIndex)
		List C = A.subList(3, 5);
		System.out.println("���������õļ���Ϊ");
		for(Object each:C)//��ӡ����C
		{
			System.out.println(each);
		}
		
	}
	
}

