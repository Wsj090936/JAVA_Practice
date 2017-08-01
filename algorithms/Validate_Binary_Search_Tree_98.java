package algorithms;

import java.util.ArrayList;
import java.util.List;

/**
 *  Given a binary tree, determine if it is a valid binary search tree (BST).

	Assume a BST is defined as follows:
	
	The left subtree of a node contains only nodes with keys less than the node's key.
	The right subtree of a node contains only nodes with keys greater than the node's key.
	Both the left and right subtrees must also be binary search trees.
	Example 1:
	    2
	   / \
	  1   3
	Binary tree [2,1,3], return true.
	Example 2:
	    1
	   / \
	  2   3
	Binary tree [1,2,3], return false.
 * @author wushijia
 *��ĿҪ��:����һ����������Ҫ�������ж����ǲ���һ����Ч�Ķ���������
 *˼·:���ڶ���������������֪�����������ȥ����һ�������������õ��Ľ����һ�����������У��������ǿ�����������������������
 *Ȼ��ȥ�ж������ǲ���һ�����������С��ǵĻ����򷵻�true���������ǣ��򷵻�false
 */
public class Validate_Binary_Search_Tree_98 {
    List<Integer> list = new ArrayList<>();
    public boolean isValidBST(TreeNode root) {
        if(root == null){
        	return true;
        }
        if(root.left == null && root.right == null){
        	return true;
        }
        inorderTraversal(root);
        for(int i = 1; i < list.size();i++){
        	if(list.get(i) <= list.get(i - 1)){
        		return false;
        	}
        }
        return true;
        
    }
    public void inorderTraversal(TreeNode root){
        if(root == null){
        	return ;
        }
        inorderTraversal(root.left);
        list.add(root.val);
        inorderTraversal(root.right);
    }
}
