package algorithms;

import java.util.Stack;
/*
 *  Given an absolute path for a file (Unix-style), simplify it.

	For example,
	path = "/home/", => "/home"
	path = "/a/./b/../../c/", => "/c"
	˼·:�������˼�������Ǽ�һ��·���������ȣ�����֪��Unix�µ�·�����У���Ŀ¼֮�䶼��"/"����������"."��ʾ��ǰĿ¼�£�".."��ʾ��һ��Ŀ¼
	�������ǿ��Խ���·���ַ�������"/"���Ϊ�����ַ�������ֳ����ַ�������������:�� һ��Ŀ¼�� �� "" �� "." �� ".."
	Ȼ���ж�ÿһ���ַ��������ݣ����Ϊ""����Ϊ"."���ǾͲ����������Ϊһ��������Ŀ¼����������ջ�����Ϊ".."������ջ����Ԫ�أ����ʾΪ��Ŀ¼��
	ͬ�����ǲ������������ջ����Ԫ�أ���ջ��Ԫ�ص�����Ȼ������ѭ�����������򻯺��·�������Խ�ջ��Ԫ�����ε�������������"/"ƴ���������ɡ�
 */
public class SimplifyPath_71 {
	public static void main(String[] args) {
		String s = "/..";
		System.out.println(simplifyPath(s));
	}
    public static String simplifyPath(String path) {
    	Stack<String> s = new Stack<>();
    	String[] path1 = path.split("/");//����б�߽��ַ�����Ϊ�����ַ�������
    	String ss = "";
    	for(int i = 0;i < path1.length;++i){
    		if(path1[i].equals("") || path1[i].equals(".")){//����""����"."�Ͳ�������
    			
    		}else if(path1[i].equals("..")){
    			if(!s.isEmpty())//�������"..",����ջ����Ԫ�أ������Ϊ��Ŀ¼����������
    				s.pop();
    		}else{
    			s.push(path1[i]);
    		}
    	}
    	if(s.isEmpty()){
    		return "/";
    	}
    	while(!s.isEmpty()){
    		ss = "/"+s.pop()+ss;
    	}
    	
		return ss;
        
    }
}
