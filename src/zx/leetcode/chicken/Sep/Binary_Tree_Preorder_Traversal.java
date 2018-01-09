package zx.leetcode.chicken.Sep;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Binary_Tree_Preorder_Traversal {
	
    public List<Integer> preorderTraversal(TreeNode root) {
    	Stack<TreeNode> stack = new Stack<TreeNode>();
    	if(root==null)return new ArrayList<Integer>();
    	List<Integer> resList = new ArrayList<Integer>();
    	
    	stack.push(root);
    	while(!stack.isEmpty()){
    		TreeNode popNode = stack.pop();
    		if(popNode!=null){
    			resList.add(popNode.val);
    		}
    		if(popNode.right!=null)stack.push(popNode.right);
    		if(popNode.left!=null)stack.push(popNode.left);
    	}
        return resList;
    }
    
    public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.right = new TreeNode(2);
		root.right.left = new TreeNode(3); 
		new Binary_Tree_Preorder_Traversal().preorderTraversal(root);
		
	}
    
    static class TreeNode{
    	TreeNode left;
    	TreeNode right;
    	int val;
    	TreeNode(int x){
    		val = x;
    	}
    }

}
