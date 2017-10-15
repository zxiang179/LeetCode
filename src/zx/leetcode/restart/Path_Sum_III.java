package zx.leetcode.restart;

public class Path_Sum_III {
	
	/**
	 * 先序遍历 求值
	 * @param root
	 * @param sum
	 * @return
	 */
	public int pathSum(TreeNode root, int sum) {
        //判断特殊情况
		 if(root==null)return 0;
		 return findPath(root,sum)+findPath(root.left,sum)+findPath(root.right,sum);
    }
	
	public int findPath(TreeNode root,int sum){
		if(root==null)return 0;
		//记录符合条件的总数
		return sum==root.val?1:0+findPath(root.left,sum-root.val)+findPath(root.right,sum-root.val);
	}

	class TreeNode{
		TreeNode left;
		TreeNode right;
		int val;
		public TreeNode(int x){
			val = x;
		}
	}
}
