package zx.leetcode.chicken.july;
/**
 * 230. Kth Smallest Element in a BST
 * @author Carl_Hugo
 * @date 2017年7月10日
 */
public class Test15 {
	
    public int kthSmallest(TreeNode root, int k) {
        int count = countNode(root.left);
        if(k<=count){
        	return kthSmallest(root.left,k);
        }else if(k>count+1){
        	return kthSmallest(root.right,k-1-count);
        }
        return root.val;
    }
    
    public int countNode(TreeNode n){
    	if(n==null)return 0;
    	return 1+countNode(n.left)+countNode(n.right);
    }
    
    class TreeNode{
    	TreeNode left;
    	TreeNode right;
    	int val;
    	TreeNode(int x){
    		x = val;
    	}
    }

}
