package zx.leetcode.chicken.restart;

import zx.leetcode.chicken.restart.Binary_Tree_Path.TreeNode;

public class Path_Sum {
	
	public boolean hasPathSum(TreeNode root,int sum){
		if(root==null)return false;
		if(root.left==null&&root.right==null){
			if(sum-root.val==0)return true;
		}
		return hasPathSum(root.left,sum-root.val)||hasPathSum(root.right,sum-root.val);
	}

}
