package algorithms;

import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;
import java.util.Queue;
/**
 *  Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.

	For example:
	Given the following binary tree,
	   1            <---
	 /   \
	2     3         <---
	 \     \
	  5     4       <---
	You should return [1, 3, 4].
 * @author wushijia
 *��Ŀ���⣺����һ���������������������Լ�վ�ڶ��������ұߣ���дһ�������������ܹ������Ķ������Ľڵ㼯��
 *˼·�������ÿ�������������ó�ÿһ��ļ��ϣ�Ȼ����ȡ��ÿһ��ļ��Ͻ�ÿһ��ļ����е����һ��Ԫ�����
 *��һ���µļ�����������ɡ�
 */
public class Binary_Tree_Right_Side_View_199 {
    public List<Integer> rightSideView(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if(root == null){
            return new ArrayList<>();
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int size = 1;
        while(!queue.isEmpty()){
            List<Integer> tmp = new ArrayList<>();
            for(int i = 0;i < size; i++){
                TreeNode node = queue.poll();
                tmp.add(node.val);
                if(node.left != null){
                    queue.add(node.left);
                }
                if(node.right != null){
                    queue.add(node.right);
                }
            }
            list.add(tmp);
            size = queue.size();
        }
        List<Integer> res = new ArrayList<>();
        for(List<Integer> each : list){
            res.add(each.get(each.size() - 1));
        }
        return res;
    }
}
