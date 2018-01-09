package zx.leetcode.chicken.restart;

import java.util.LinkedList;
import java.util.Queue;

import zx.leetcode.chicken.restart.Binary_Tree_Path.TreeNode;

public class Symmetric_Tree {
	
	public boolean isSymmetric(TreeNode root) {
		if(root==null)return true;
		return isSameTree(root.left, root.right);
    }
	
	public boolean isSameTree(TreeNode p,TreeNode q){
		//镜像判断是否相等
		if(p==null&&q==null)return true;
		if(p==null||q==null)return false;
		if(p.val==q.val){
			return isSameTree(p.left,q.right)&&isSameTree(p.right,q.left);
		}else{
			return false;
		}
	}

}
