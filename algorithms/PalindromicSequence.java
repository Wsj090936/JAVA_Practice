package algorithms;

import java.util.Scanner;

import org.junit.Test;

/*
 * 	���һ��������������֮���ԭ������һ���ľͳ���������������Ϊ�������С����磺 
	{1, 2, 1}, {15, 78, 78, 15} , {112} �ǻ�������, 
	{1, 2, 2}, {15, 78, 87, 51} ,{112, 2, 11} ���ǻ������С� 
	���ڸ���һ���������У�����ʹ��һ��ת�������� 
	ѡ�������������ڵ�����Ȼ��������Ƴ������������������������ֵĺͲ��뵽��������֮ǰ��λ��(ֻ����һ����)�� 
	���ڶ�����������Ҫ���������Ҫ���ٴβ������Խ����ɻ�������
	��������: 
	����Ϊ���У���һ��Ϊ���г���n ( 1 �� n �� 50) 
	�ڶ���Ϊ�����е�n������item[i] (1 �� iteam[i] �� 1000)���Կո�ָ���
	
	�������: 
	���һ��������ʾ������Ҫ��ת������
	
	��������: 
	4 
	1 1 1 3
	
	�������: 
	2
 */
public class PalindromicSequence {
public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();//����ĵ�һ����Ϊ���������ֵĸ���
		int[] arr = new int[n];//����Ŀռ�Ϊ���������ֵĸ���
		for(int i = 0;i<n;i++){
			arr[i] = scanner.nextInt();//��������
		}
		scanner.close();
		int times = 0;//��¼ת������
		int start = 0;//�����׸�Ԫ���±�
		int end = n - 1;//�������һ��Ԫ���±�
		while(start<end){
			if(arr[start] < arr[end]){//����Ԫ��С��βԪ��
				arr[++start] = arr[start] + arr[start + 1];//����Ԫ�غ����Ԫ���滻
				times++;
			}else if(arr[start] > arr[end]){//����Ԫ�ش���βԪ��
				arr[--end] = arr[end] + arr[end+1];//��βԪ��ǰ���Ԫ���滻
				times++;
			}else{
				start++;
				end--;
			}
		}
		System.out.println(times);
	}
}
