package zx.leetcode.dog.mar;

public class Construct_Binary_Tree_from_Inorder_and_Postorder_Traversal_106 {

	/**
	 * inorder = [9,3,15,20,7] postorder = [9,15,7,20,3]
	 * 
	 * @param inorder
	 * @param postorder
	 * @return
	 */
	public TreeNode buildTree(int[] inorder, int[] postorder) {
		if (inorder == null || postorder == null || inorder.length == 0
				|| postorder.length == 0) {
			return null;
		}
		TreeNode node = constructTree(inorder, postorder, 0,
				inorder.length - 1, 0, postorder.length - 1);
		return node;
	}

	private TreeNode constructTree(int[] inorder, int[] postorder, int s1,
			int e1, int s2, int e2) {
		if (s1 > e1 || s2 > e2) {
			return null;
		}
		int rootVal = postorder[e2];
		int rootIndex = -1;
		for(int i=s1;i<=e1;i++){
			if(rootVal==inorder[i]){
				rootIndex = i;
				break;
			}
		}
		TreeNode root = new TreeNode(rootVal);
		root.left = constructTree(inorder,postorder,s1,rootIndex-1,s2,s2+(rootIndex-s1)-1);
		root.right = constructTree(inorder,postorder,rootIndex+1,e1,s2+(rootIndex-s1),e2-1);
		return root;
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
