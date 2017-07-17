package zx.leetcode.july;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 515. Find Largest Value in Each Tree Row
 * @author Carl_Hugo
 *
 */
public class Test21 {
	
	public List<Integer> largestValues(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        List<Integer> resList = new ArrayList<Integer>();
        if(root==null)return resList;
        queue.add(root);
        
        while(!queue.isEmpty()){
        	int max = Integer.MIN_VALUE;
        	int size = queue.size();
        	for(int i=0;i<size;i++){
        		TreeNode node = queue.poll();
        		int val = node.val;
        		if(val>=max)max = val;
        		if(node.left!=null)queue.add(node.left);
        		if(node.right!=null)queue.add(node.right);
        	}
        	resList.add(max);
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
