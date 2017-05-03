package zx.leetcode.may;
/**
 * 563. Binary Tree Tilt
 * @author Carl_Hugo
 * @date 2017年5月3日
 */
public class Test3 {
	
	/*Input: 
	        1
	      /   \
	     2     3
		Output: 1
		Explanation: 
		Tilt of node 2 : 0
		Tilt of node 3 : 0
		Tilt of node 1 : |2-3| = 1
		Tilt of binary tree : 0 + 0 + 1 = 1*/

	class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x){val=x;}
	}
	int sum=0;
	/**
	 * 后序遍历 return leftSum+rightSum+root.val;
	 * @param root
	 * @return
	 */
    public int findTilt(TreeNode root) {
        postOrder(root);
        return sum;
    }
    
    public int postOrder(TreeNode root){
    	if(root==null)return 0;
    	int leftSum = postOrder(root.left);
    	int rightSum = postOrder(root.right);
    	sum+=Math.abs(leftSum-rightSum);
    	return leftSum+rightSum+root.val;
    }
}
