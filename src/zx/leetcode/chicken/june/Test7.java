package zx.leetcode.chicken.june;
/**
 * 617. Merge Two Binary Trees
 * @author Carl_Hugo
 * @date 2017年6月28日
 */
public class Test7 {
    
	public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if(t1==null&&t2==null)return null;
        int val = (t1!=null?t1.val:0) + (t2!=null?t2.val:0);
        TreeNode node = new TreeNode(val);
        node.left = mergeTrees(t1==null?null:t1.left,t2==null?null:t2.left);
        node.right = mergeTrees(t1==null?null:t1.right,t2==null?null:t2.right);
        return node;
    }
	
	class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x){
			val = x;
		}
	}
}
