package algorithms;
/*
 * ���⣺Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
		The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
	������Ϊһ������ƥ�����⣬��ջ����
 */
public class ValidParentheses_20 {
	public static void main(String[] args) {
		String s = "(";	
		System.out.println(isValid(s));
	}
	public static boolean isValid(String s) {
		int top = 0 ;//ջ��ָ��
		char e = 0 ;//��������ַ�����ĳһ�ַ��ı���
		char[] stack = new char[s.length()+1];//�Զ���һ��ջ
		for(int i = 0 ; s != null && i < s.length() ; ++i){
				e = s.charAt(i);
				if(e == '(' || e == '[' || e == '{'){
					stack[++top] = e;
				}else if (top == 0){
					return false;
				}else{
				if((stack[top] == '(' && e == ')') || (stack[top] == '[' && e == ']') || (stack[top] == '{' && e == '}')){
					top--;//��ƥ����һ������ʱ  �ͽ�top��һ  ��ʾ����ջ
				}else {
					return false;
				}
			}
					
		}
		return top == 0;
	}
  }


