package algorithms;
/*
 * ��һ����ά�����У�ÿһ�ж����մ����ҵ�����˳������
 * ÿһ�ж����մ��ϵ��µ�����˳�����������һ��������
 * ����������һ����ά�����һ���������ж��������Ƿ��и�������
 */
import org.junit.Test;

public class array2 {
    public boolean Find(int target, int [][] array) {
		int line = array.length;
        int list = array[0].length;
        int i = line - 1;
        int j = 0;
        for(;i>=0&&j<list;)
            {
            	if(target == array[i][j])
                    return true;
            	else if(target>array[i][j])
                    { 
                    	j = j+1;
                }else if(target<array[i][j])
                    {
                    	i = i-1;
                }
        }
		return false; 
    }
}
