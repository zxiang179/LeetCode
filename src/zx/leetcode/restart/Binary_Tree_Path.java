package zx.leetcode.restart;

import java.util.ArrayList;
import java.util.List;

public class Binary_Tree_Path {
	
	public List<String> binaryTreePaths(TreeNode root) {
		List<String> answer = new ArrayList<String>();
		if(root!=null)searchBT(root,"",answer);
		return answer;
	}
	
	public void searchBT(TreeNode root,String path,List<String> answer){
		if(root.left==null&&root.right==null)answer.add(path+root.val);
		if(root.left!=null)searchBT(root.left,path+root.val+"->",answer);
		if(root.right!=null)searchBT(root.right,path+root.val+"->",answer);
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
