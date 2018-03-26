package zx.leetcode.dog.mar;

public class Sum_Root_to_Leaf_Numbers_129 {

	public int sumNumbers(TreeNode root) {
		if (root == null)
			return 0;
		return dfs(root, 0);
	}

	private int dfs(TreeNode root, int sum) {
		if (root == null)
			return 0;
		if (root.left == null && root.right == null) {
			return sum * 10 + root.val;
		}
		return dfs(root.left, sum * 10 + root.val)
				+ dfs(root.right, sum * 10 + root.val);
	}

	static class TreeNode {
		TreeNode left;
		TreeNode right;
		int val;

		public TreeNode(int x) {
			val = x;
		}
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(0);
		// root.right = new TreeNode(3);
		// root.left.left = new TreeNode(4);
		// root.left.right = new TreeNode(5);
		// root.right.left = new TreeNode(6);
		// root.right.right = new TreeNode(7);
		System.out.println(new Sum_Root_to_Leaf_Numbers_129().sumNumbers(root));
	}

}
