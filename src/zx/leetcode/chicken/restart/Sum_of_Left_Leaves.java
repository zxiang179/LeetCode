package zx.leetcode.chicken.restart;

import java.util.LinkedList;
import java.util.Queue;


public class Sum_of_Left_Leaves {
	
	public int sumOfLeftLeaves(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		int sum = 0;
		if(root==null)return 0;
		queue.offer(root);
		
		while(!queue.isEmpty()){
			TreeNode node = queue.poll();
			if(node.left!=null&&node.left.left==null&&node.left.right==null){
				sum+=node.left.val;
			}
			if(node.left!=null)queue.offer(node.left);
			if(node.right!=null)queue.offer(node.right);
		}
		return sum;
    }
	
	class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		public TreeNode(int x){
			val = x;
		}
	}

}
