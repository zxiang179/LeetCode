package zx.leetcode.june;
/**
 * 606. Construct String from Binary Tree
 * @author Carl_Hugo
 * @date 2017年6月5日
 */
public class Test2 {

	/**
	 * 先序遍历，在二叉树两边加括号
	 * @param t
	 * @return
	 */
	public String tree2str(TreeNode t) {
	    StringBuilder sb = new StringBuilder();
	    helper(sb,t);
	    return sb.toString();
    }
	
	public void helper(StringBuilder sb,TreeNode t){
		if(t!=null){
			sb.append(t.val);
			if(t.left!=null||t.right!=null){
				sb.append("(");
				helper(sb,t.left);
				sb.append(")");
				if(t.right!=null){
					sb.append("(");
					helper(sb,t.right);
					sb.append(")");
				}
			}
		}
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
