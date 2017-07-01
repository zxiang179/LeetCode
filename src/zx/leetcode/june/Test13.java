package zx.leetcode.june;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * 107. Binary Tree Level Order Traversal II
 * @author Carl_Hugo
 * @date 2017年7月1日
 */
public class Test13 {
	
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> resultList = new ArrayList<List<Integer>>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        Stack<List> stack = new Stack<List>();
        queue.add(root);
        
        while(!queue.isEmpty()){
        	int size=queue.size();
        	List subList = new ArrayList<Integer>();
        	for(int i=0;i<size;i++){
        		TreeNode node = queue.poll();
        		Integer result = node.val;
        		subList.add(result);
        		if(node.left!=null)queue.add(node.left);
        		if(node.right!=null)queue.add(node.right);
        	}
        	stack.push(subList);
        }
        
        while(!stack.isEmpty()){
        	resultList.add(stack.pop());
        }
        return resultList;
    }
    
    class TreeNode{
    	TreeNode left;
    	TreeNode right;
    	int val;
    	TreeNode(int x){
    		val=x;
    	}
    }

}
