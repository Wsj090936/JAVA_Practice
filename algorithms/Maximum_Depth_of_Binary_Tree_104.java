package algorithms;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a binary tree, find its maximum depth.

   The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 * @author wushijia
 *
 */
public class Maximum_Depth_of_Binary_Tree_104 {
    public int DepthTree(TreeNode root){//�ݹ鷽��
    	if(root == null){
    		return 0;
    	}
    	if(root.left == null && root.right == null){
    		return 1;
    	}
    	int maxl = DepthTree(root.left);//����������
    	int maxr = DepthTree(root.right);//����������
    	return maxl > maxr ? maxl + 1 : maxr + 1;
    } 
    public int DepthTree1(TreeNode root){//�ǵݹ鷽��
    	Queue<TreeNode> queue = new LinkedList<>();
    	int ans = 0;
    	if(root == null){
    		return 0;
    	}
    	queue.add(root);
    	while(!queue.isEmpty()){
    		++ans;//ÿ��ѭ��֤�����+1
    		int n = queue.size();
    		for(int i = 0;i < queue.size();i++){//�Զ����е�ÿһ���ڵ�Ϊ���ڵ��������
    			TreeNode p = queue.peek();
    			queue.poll();
    			if(p.left != null){
    				queue.add(p.left);
    			}
    			if(p.right != null){
    				queue.add(p.right);
    			}
    		}
    	}
    	return ans;
    }
}
