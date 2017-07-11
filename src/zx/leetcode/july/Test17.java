package zx.leetcode.july;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


/**
 * 637. Average of Levels in Binary Tree
 * @author Carl_Hugo
 * @date 2017年7月11日
 */
public class Test17 {
	
	/**
	 * Given a non-empty binary tree, 
	 * return the average value of the nodes on each level in the form of an array.
	 * @param root
	 * @return
	 */
	public List<Double> averageOfLevels(TreeNode root) {
	     Queue<TreeNode> queue = new LinkedList<TreeNode>();
	     List<Double> resList = new ArrayList<Double>();
	     queue.add(root);
	     while(!queue.isEmpty()){
	    	 Double sum=0.0;
	    	 int size=queue.size();
	         for(int i=0;i<size;i++){
	    	    TreeNode node = queue.poll();
	    	    sum+=node.val;
		    	if(node.left!=null)queue.add(node.left);
		    	if(node.right!=null)queue.add(node.right);	 
	    	 }
	         resList.add((Double)sum/size);
	     }
	     return resList;
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
