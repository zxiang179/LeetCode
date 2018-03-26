package zx.leetcode.dog.mar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Path_Sum_2 {

	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		List<List<Integer>> resList = new ArrayList<List<Integer>>();
		List<Integer> tempList = new LinkedList<Integer>();
		dfs(root, sum, resList, tempList);
		return resList;
	}

	private void dfs(TreeNode root, int sum, List<List<Integer>> resList,
			List<Integer> tempList) {
		if (root == null)
			return;
		tempList.add(root.val);
		if (root.val == sum && root.left == null && root.right == null) {
			resList.add(new ArrayList(tempList));
		}
		dfs(root.left, sum - root.val, resList, tempList);
		dfs(root.right, sum - root.val, resList, tempList);
		// 回溯
		tempList.remove(tempList.size() - 1);
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(4);
		root.right = new TreeNode(8);
		root.left.left = new TreeNode(11);
		root.left.left.left = new TreeNode(7);
		root.left.left.right = new TreeNode(2);
		root.right.left = new TreeNode(13);
		root.right.right = new TreeNode(4);
		root.right.right.left = new TreeNode(5);
		root.right.right.right = new TreeNode(1);
		new Path_Sum_2().pathSum(root, 22);

	}

	static class TreeNode {
		TreeNode left;
		TreeNode right;
		int val;

		public TreeNode(int x) {
			val = x;
		}
	}

}
