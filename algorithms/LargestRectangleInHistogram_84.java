package algorithms;
/*
 * ��������Ĵ�С  ��ţ�84
 */
public class LargestRectangleInHistogram_84 {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] stack = new int[n + 1];//ջ�д�ŵ�����������heights���±�
        int top = 0;
        int[] l = new int[n];//�������д洢��ÿһ�����������쵽��ߵ�����λ��
        int[] r = new int[n];//�������д洢��ÿһ�����������쵽�ұߵ�����λ��
        for(int i = 0; i < n ;i++){//��߱���
            for(;top > 0 && heights[i] <= heights[stack[top]];top--);
            l[i] = top == 0 ? 0 : stack[top] + 1;
            stack[++top] = i;
        }
            top = 0;
        for(int i = n - 1;i>=0;i--){
            for(;top > 0 && heights[i] <= heights[stack[top]];top--);
            r[i] = top == 0 ? n-1 : stack[top] - 1;
            stack[++top] = i;
        }
        int answer = 0;
        for(int i = 0;i < n;i++){
            answer = Math.max(answer,(r[i] - l[i] + 1) * heights[i]);
        }
        return answer;
    }
}
