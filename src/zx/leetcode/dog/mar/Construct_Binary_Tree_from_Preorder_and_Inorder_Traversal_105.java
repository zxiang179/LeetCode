package zx.leetcode.dog.mar;

public class Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal_105 {

	/**
	 * preorder = [3,9,20,15,7] inorder = [9,3,15,20,7]
	 * 
	 * @param preorder
	 * @param inorder
	 * @return
	 */
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		if (preorder == null || inorder == null || inorder.length == 0
				|| preorder.length == 0) {
			return null;
		}
		TreeNode node = constructTree(preorder, inorder, 0,
				preorder.length - 1, 0, inorder.length - 1);
		// print(node);
		return node;

	}

	public TreeNode constructTree(int[] preorder, int[] inorder, int s1,
			int e1, int s2, int e2) {
		if (s1 > e1 || s2 > e2)
			return null;
		int rootVal = preorder[s1];
		int inOrderRootIndex = -1;
		for (int i = 0; i < inorder.length; i++) {
			if (rootVal == inorder[i]) {
				inOrderRootIndex = i;
			}
		}
		TreeNode root = new TreeNode(rootVal);
		root.left = constructTree(preorder, inorder, s1 + 1, s1
				+ (inOrderRootIndex - s2), s2, inOrderRootIndex - 1);
		root.right = constructTree(preorder, inorder, s1
				+ (inOrderRootIndex - s2) + 1, e1, inOrderRootIndex + 1, e2);
		return root;
	}

	public static void main(String[] args) {
		new Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal_105()
				.buildTree(new int[] { 3, 9, 20, 15, 7 }, new int[] { 9, 3, 15,
						20, 7 });
	}

	public void print(TreeNode node) {
		if (node.left != null)
			print(node.left);
		if (node != null) {
			System.out.println(node.val);
		}
		if (node.right != null)
			print(node.right);

	}

	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		public TreeNode(int x) {
			val = x;
		}
	}

}
