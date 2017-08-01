package algorithms;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Ҫ��ʵ�ֶ��������������
 * @author wushijia
 *
 */
public class Binary_Tree_Inorder_Traversal_94 {
    public List<Integer> inorderTraversal(TreeNode root) {//�ݹ鷽ʽ
    	List<Integer> list = new ArrayList<>();
    	if(root == null){
    		return list;
    	}
    	list.addAll(inorderTraversal(root.left));
    	list.add(root.val);
    	list.addAll(inorderTraversal(root.right));
    	return list;
    }
    public List<Integer> inorderTraversal1(TreeNode root) {//�ǵݹ鷽ʽ
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        if(root == null){
            return list;
        }
        while(!stack.isEmpty() || root != null){
            if(root != null){
                stack.push(root);
                root = root.left;
            }else{
                root = stack.pop();
                list.add(root.val);
                root = root.right;
            }
        }
        return list;
    }
}
