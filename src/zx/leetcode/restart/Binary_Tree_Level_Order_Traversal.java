package zx.leetcode.restart;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import zx.leetcode.restart.Binary_Tree_Path.TreeNode;

public class Binary_Tree_Level_Order_Traversal {

	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> resList = new ArrayList<List<Integer>>();
		if(root==null)return null;
		return levelOrder(resList,0,root);
	}
	
	public List<List<Integer>> levelOrder(List<List<Integer>> resList,int level,TreeNode root){
        if(resList.size()<=level){
        	//增加一个子list
        	resList.add(level,new ArrayList<Integer>());
        }
        resList.get(level).add(root.val);
    	if(root.left!=null)levelOrder(resList,level+1,root.left);
    	if(root.right!=null)levelOrder(resList,level+1,root.right);
    	return resList;
	
	}
	
}
