package zx.leetcode.dog.apri;

import java.util.Stack;

public class kth_smallest_element_in_a_BST_230 {
	
	public int kthSmallest(TreeNode root, int k) {
		Stack<TreeNode> stack = new Stack();
		TreeNode n = root;
		while(n.left!=null) {
			stack.push(n.left);
			n = n.left;
		}
		while(k>0&&(n!=null||!stack.isEmpty())) {
			if(n==null) {
				n = stack.pop();
				if(--k==0)return n.val;
				n = n.right;
			}else {
				stack.push(n);
				n = n.left;
			}
		}
		return n.val;
		
    }
	
	static class TreeNode {
		TreeNode left;
		TreeNode right;
		int val;
		TreeNode(int x){
			val = x;
		}
	}

}
