package zx.leetcode.may;
/**
 * 543. Diameter of Binary Tree
 * @author Carl_Hugo
 * @date 2017年5月5日
 */
public class Test11 {
	
	/**
	 * Given a binary tree, you need to compute the length of the diameter of the tree. 
	 * The diameter of a binary tree is the length of the longest path between any two nodes in a tree. 
	 * This path may or may not pass through the root.
	 * for every node maxLength= (max left length+max right length)
	 * @param root
	 * @return
	 */
    public int diameterOfBinaryTree(TreeNode root) {
        return maxLength(root);
    }
    
    int max = 0;
    public int maxLength(TreeNode root){
    	if(root==null)return 0;
    	int left = maxLength(root.left);
    	int right = maxLength(root.right);
    	max = Math.max(max, left+right);
    	return  Math.max(left, right)+1;
    }

}

class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x){val=x;}
}