package zx.leetcode.restart;

import zx.leetcode.restart.Binary_Tree_Path.TreeNode;

public class Maximum_Depth_of_Binary_Tree {
	
	public int maxDepth(TreeNode root) {
		if(root==null)return 0;
		if(root.left==null&&root.right==null)return 1;
		return Math.max(maxDepth(root.left), maxDepth(root.right))+1;
    }

}
