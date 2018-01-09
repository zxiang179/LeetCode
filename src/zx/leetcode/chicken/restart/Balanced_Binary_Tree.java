package zx.leetcode.chicken.restart;

import zx.leetcode.chicken.restart.Binary_Tree_Path.TreeNode;

public class Balanced_Binary_Tree {
	
	public boolean isBalanced(TreeNode root){
		if(root==null){
			return true;
		}
		if(Math.abs(getHeight(root.left)-getHeight(root.right))>1){
			return false;
		}else{
			return isBalanced(root.left)&&isBalanced(root.right);
		}
	}
	
	public int getHeight(TreeNode root){
		if(root==null)return 0;
		//叶子结点
		if(root.left==null&&root.right==null){
			return 1;
		}
		return Math.max(getHeight(root.left),getHeight(root.right))+1;
	}

}
