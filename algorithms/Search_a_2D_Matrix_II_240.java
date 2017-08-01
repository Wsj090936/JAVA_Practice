package algorithms;
/**
 *  Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

	Integers in each row are sorted in ascending from left to right.
	Integers in each column are sorted in ascending from top to bottom.
	For example,
	
	Consider the following matrix:
	
	[
	  [1,   4,  7, 11, 15],
	  [2,   5,  8, 12, 19],
	  [3,   6,  9, 16, 22],
	  [10, 13, 14, 17, 24],
	  [18, 21, 23, 26, 30]
	]
	Given target = 5, return true.
	
	Given target = 20, return false.
	
	��Ŀ���⣺����һ����ά���飬�����е����ִ�С������һ�ε��������ϵ������εݼ������ڸ���һ������
	�ú̵ܶ�ʱ���жϸ����Ƿ���������������
	˼·: ����������Ͻǻ������½ǿ�ʼѰ�ң��ͻ�ʹ��ʱ�������
 * @author wushijia
 *
 */
public class Search_a_2D_Matrix_II_240 {
    public boolean searchMatrix(int[][] matrix, int target) {
    	if(matrix.length == 0){
    		return false;
    	}
    	int i = 0;//�����Ͻǿ�ʼ
    	int j = matrix[0].length - 1;//��
    	while(i < matrix.length && j >= 0){
    		if(target > matrix[i][j]){
    			++i;
    		}else if(target < matrix[i][j]){
    			--j;
    		}else return true;
    	}
    	return false;
    }
}
