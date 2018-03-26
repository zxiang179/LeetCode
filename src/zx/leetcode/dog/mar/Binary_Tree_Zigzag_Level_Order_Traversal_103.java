package zx.leetcode.dog.mar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class Binary_Tree_Zigzag_Level_Order_Traversal_103 {
	
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> resList = new ArrayList<List<Integer>>();
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		boolean cur = false;
		if(root==null){
			return resList;
		}
		queue.add(root);
		while(!queue.isEmpty()){
			System.out.println("queue size "+queue.size());
			int count = queue.size();
			List<Integer> tempList = new ArrayList<Integer>();
			while(count-->0){
				TreeNode treeNode = queue.poll();
				tempList.add(treeNode.val);
				if(treeNode.left!=null){
					queue.add(treeNode.left);
				}
				if(treeNode.right!=null){
					queue.add(treeNode.right);
				}
			}
			if(cur){
				Collections.reverse(tempList);
			}
			cur = !cur;
			resList.add(tempList);
		}
		return resList;
    }
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		new Binary_Tree_Zigzag_Level_Order_Traversal_103().zigzagLevelOrder(root);
	}
	
	
	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		public TreeNode(int x) {
			val = x;
		}
	}
	

}
