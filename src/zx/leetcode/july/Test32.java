package zx.leetcode.july;
/**
 * 538. Convert BST to Greater Tree
 * @author Carl_Hugo
 * 2017年7月26日 上午11:00:42
 */
public class Test32 {

	/**
	 * 给一个二叉搜索树， 将它转化为更大的二叉树，使得节点的值为原始节点的值加上所有比它大的节点的值之和，并且使转化后的二叉树的左子树大于右子树。
	 * 后续遍历
	 * @param root
	 * @return
	 */
    public TreeNode convertBST(TreeNode root) {
        helper(root,0);
        return root;
    }
    
    public int helper(TreeNode root,int plus){
    	if(root==null)return 0;
    	int right = helper(root.right,plus);
    	int left = helper(root.left,plus+right+root.val);
    	int result = right+left+root.val;
    	root.val=plus+right+root.val;
    	return result;
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
