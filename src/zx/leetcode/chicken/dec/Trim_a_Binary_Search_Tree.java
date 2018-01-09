package zx.leetcode.chicken.dec;
/**
 * 669. Trim a Binary Search Tree
 * @author Carl_Hugo
 * 2017年12月6日 下午4:01:33
 */
public class Trim_a_Binary_Search_Tree {
	
	public TreeNode trimBST(TreeNode root, int L, int R) {
        if(root==null)return null;
        if(root.val<L)return trimBST(root.right,L,R);
        if(root.val>R)return trimBST(root.left,L,R);
        root.left = trimBST(root.left,L,R);
        root.right = trimBST(root.right,L,R);
		return root;
    }
	
	class TreeNode{
		TreeNode left;
		TreeNode right;
		int val;
		TreeNode(int x){
			val = x;
		}
	}

}
