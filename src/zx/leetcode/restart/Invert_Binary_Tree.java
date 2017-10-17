package zx.leetcode.restart;

public class Invert_Binary_Tree {
	
	public TreeNode invertTree(TreeNode root) {
		if(root==null)return null;
		if(root.left==null&&root.right==null)return null;
		TreeNode temp = root.left;
		root.left = root.right;
		root.right = temp;
		if(root.left!=null)invertTree(root.left);
		if(root.right!=null)invertTree(root.right);
		return root;
	}
	
	class TreeNode{
		TreeNode left;
		TreeNode right;
		int val;
		public TreeNode(int x){
			val = x;
		}
	}

}
