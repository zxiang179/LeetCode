package zx.leetcode.dog.july.pingduoduo.test;

public class Test3 {
	
	class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		public TreeNode(int v) {
			this.val = v;
		}
	}
	
	public boolean symTree(TreeNode root){
		if(root==null)return true;
		if(root.left==null&&root.right==null)return true;
		if(root.left==null||root.right==null)return false;
		return isSameTree(root.left,root.right);
	}
	
	public boolean isSameTree(TreeNode p,TreeNode q) {
		if(p==null&&q==null)return true;
		if(p==null||q==null)return false;
		if(p.val==q.val){
			return isSameTree(p.left,q.left)&&isSameTree(p.right,q.right);
		}else {
			return false;
		}
	}

}
