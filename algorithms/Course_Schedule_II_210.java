package algorithms;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 *  There are a total of n courses you have to take, labeled from 0 to n - 1.

	Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]
	
	Given the total number of courses and a list of prerequisite pairs, return the ordering of courses you should take to finish all courses.
	
	There may be multiple correct orders, you just need to return one of them. If it is impossible to finish all courses, return an empty array.
	
	For example:
	
	2, [[1,0]]
	There are a total of 2 courses to take. To take course 1 you should have finished course 0. So the correct course order is [0,1]
	
	4, [[1,0],[2,0],[3,1],[3,2]]
	There are a total of 4 courses to take. To take course 3 you should have finished both courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0. So one correct course order is [0,1,2,3]. Another correct ordering is[0,2,1,3].
	
	Note:
	The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.
	You may assume that there are no duplicate edges in the input prerequisites.
	���������������ж����޻����л������һ�������飬�޻������һ����˳���޿ε�����
 */
public class Course_Schedule_II_210 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] num = new int[numCourses];//����ȵ�����
        List<Integer>[] list = new ArrayList[numCourses];
        for(int i = 0;i < numCourses;i++){//��ʼ���ڽӱ�
            list[i] = new ArrayList<>();
        }
        for(int i = 0;i < prerequisites.length;i++){
            num[prerequisites[i][0]]++;//��ʼ�����
            list[prerequisites[i][1]].add(prerequisites[i][0]);//�������
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0;i < numCourses;i++){
            if(num[i] == 0){//�����Ϊ0�ĵ������
                queue.add(i);
            }
        }
        int[] course = new int[numCourses];//�޿�˳�������
        int count = 0;
        while(!queue.isEmpty()){
            int point = queue.poll();
            course[count++] = point;
            for(Integer each : list[point]){
                if(--num[each] == 0){//���Ϊ0�������
                    queue.add(each);
                }
            }
        }
        if(count != numCourses){//�л������һ��������
            return new int[0];
        }
        return course;
    }
}
