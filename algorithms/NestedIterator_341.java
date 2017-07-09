package algorithms;

import java.util.Stack;
/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
/*
˼·:������������ջ���������Ƚ��б�nestedList�е�Ԫ�شӺ���ǰ������ջ������ջ�����ԣ��Ϳ��Խ��б��еĵ�һ��Ԫ�ص�һ������
��������Ҫ����hasnext()�������ж���һ��Ԫ���Ƿ�Ϊ���������������peek()�ŷ���ȡջ��Ԫ��(Ҳ�����б��е�һ��Ԫ�ص�ֵ)�����Ϊ
�������򷵻�true�������ǣ�����һ����һ���б��ͽ��䵯�������Ӻ���ǰ������������֮�е�Ԫ����ջ��Ȼ�������ѭ����
*/
public class NestedIterator implements Iterator<Integer> {
  public Stack<NestedInteger> s = new Stack<NestedInteger>();
  public NestedIterator(List<NestedInteger> nestedList) {
      if(nestedList != null){
      for(int i = nestedList.size() - 1; i >= 0;--i){//���б�Ԫ�ص�����ջ
          s.push(nestedList.get(i));
      }
    }
  }

  @Override
  public Integer next() {
      NestedInteger e = s.pop();
      return e.getInteger();
  }

  @Override
  public boolean hasNext() {
      while(!s.isEmpty()){
          NestedInteger e = s.peek();
          if(e.isInteger()){//���Ϊ����  ����true
              return true;
          }else{
              s.pop();//���������ͽ�ջ��Ԫ�ص�����Ȼ�󽫵���Ԫ�ر����������е����ִӺ���ǰ����ջ��
              for(int i = e.getList().size()-1; i >= 0 ;--i){
                  s.push(e.getList().get(i));
              }
          }
      }
      return false;
  }
}
/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */