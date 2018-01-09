package zx.leetcode.chicken.restart;

import zx.leetcode.chicken.restart.Binary_Tree_Path.TreeNode;

public class Same_Tree {
	
	public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null&&q==null)return true;
        if(p==null||q==null)return false;
        if(p.val==q.val){
        	return isSameTree(p.left,q.left)&&isSameTree(p.right,q.right);
        }else{
        	return false;
        }
    }

}
