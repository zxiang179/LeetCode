package zx.leetcode.dog.nowcoder.sword2offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	public TreeNode(int x) {
		val = x;
	}
}

public class Solution4 {
	
	public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        if(root!=null) {
        	queue.offer(root);
        	while(!queue.isEmpty()) {
        		TreeNode node = queue.poll();
        		list.add(node.val);
        		if(node.left!=null)queue.offer(node.left);
        		if(node.right!=null)queue.offer(node.right);
        	}
        }
        return list;
    }
}
