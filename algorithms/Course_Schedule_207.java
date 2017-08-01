package algorithms;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 *  There are a total of n courses you have to take, labeled from 0 to n - 1.

	Some courses may have prerequisites, for example to take course 0 you have to first take course 1,
	which is expressed as a pair: [0,1]
	
	Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?
	
	For example:
	
	2, [[1,0]]
	There are a total of 2 courses to take. To take course 1 you should have finished course 0. So it is possible.
	
	2, [[1,0],[0,1]]
	There are a total of 2 courses to take. To take course 1 you should have finished course 0, 
	and to take course 0 you should also have finished course 1. So it is impossible.
	����Ϊ��������
 */
public class Course_Schedule_207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
    	int[] num = new int[numCourses];//������ÿһ�ſγ̵����
    	List<Integer>[] list = new ArrayList[numCourses]; //�ڽӱ��������
    	for(int i = 0; i < numCourses;i++){//��ʼ���ڽӱ�
    		list[i] = new ArrayList<>();
    	}
    	for(int i = 0; i < prerequisites.length; i++){//���ߴ����ڽӱ�
    		num[prerequisites[i][0]]++;//ÿ�������ñ�һ�Σ���ʹ����ȼ�һ
    		list[prerequisites[i][1]].add(prerequisites[i][0]);
    	}
    	Queue<Integer> queue = new LinkedList<>();
    	for(int i = 0; i < numCourses;i++){//�����Ϊ0�ĵ������
    		if(num[i] == 0){
    			queue.add(i);
    		}
    	}
    	int count = 0;//����ֵ��ͳ�Ʊ����˶��ٸ��㣬�����������numCourses��ͬ�����ͼ�в����ڻ�
    	while(!queue.isEmpty()){
    		Integer point = queue.poll();//�����еĶ�ͷ������
    		count++;
    		for(Integer each : list[point]){//�Ӹոճ����еĵ㿪ʼ����
    			--num[each];//ÿ����һ�����ʹ�øõ����ȼ�һ
    			if(num[each] == 0){
    				queue.add(each);//���Ϊ1�������
    			}
    		}
    	}
    	return count == numCourses;
    }
}
