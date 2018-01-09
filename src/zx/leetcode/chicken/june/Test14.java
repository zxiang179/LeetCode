package zx.leetcode.chicken.june;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 94. Binary Tree Inorder Traversal 
 * @author Carl_Hugo
 * @date 2017年7月1日
 */
public class Test14 {
	
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> resultList = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        if(root==null)return resultList;
        
        TreeNode cur = root;
        while(!stack.isEmpty()||cur!=null){
        	while(cur!=null){
        		stack.push(cur);
        		cur=cur.left;
        	}
        	cur = stack.pop();
        	resultList.add(cur.val);
        	cur=cur.right;
        }
        return resultList;
    }
    
    class TreeNode{
    	TreeNode left;
    	TreeNode right;
    	int val;
    	TreeNode(int x){
    		val = x;
    	}
    	
    }

}
