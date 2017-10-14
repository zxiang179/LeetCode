package zx.leetcode.restart;

public class Lowest_Common_Ancestor_of_a_Binary_Search_Tree {
	
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null||p==null||q==null){
        	return null;
        }
        if(p.val<root.val&&q.val<root.val){
        	return lowestCommonAncestor(root.left,p,q);	
        }else if(p.val>root.val&&q.val>root.val){
        	return lowestCommonAncestor(root.right, p, q);
        }else{
        	return root;
        }
    }
	
	class TreeNode{
		int val;
		public TreeNode(int x){
			val = x;
		}
		TreeNode left;
		TreeNode right;
	} 

}
