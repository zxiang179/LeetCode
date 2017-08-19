package zx.leetcode.Aug;

import java.util.ArrayList;
import java.util.List;

/**
 * 653. Two Sum IV - Input is a BST
 * @author Carl_Hugo
 * @date 2017年8月19日
 */
public class Test13 {
	
	/**
	 * 判断有序二叉树中是否存在两个数之和为给定值
	 * @param n
	 * @return
	 */
    public boolean findTarget(TreeNode root, int k) {
        if(root==null)return false;
        List<Integer> list = new ArrayList<Integer>();
        inOrder(root,list);
        int i=0,j=list.size()-1;
        while(i<j){
        	int jVal = list.get(j);
        	int iVal = list.get(i);
        	if(iVal+jVal>k){
        		j--;
        	}else if(iVal+jVal<k){
        		i++;
        	}else{
        		return true;
        	}
        }
    	return false;
    }
    
    public void inOrder(TreeNode root,List<Integer> list){
    	if(root==null)return;
    	if(root.left!=null)inOrder(root.left,list);
    	list.add(root.val);
    	if(root.right!=null)inOrder(root.right,list);
    }
    
    static class TreeNode{
    	int val;
    	TreeNode left;
    	TreeNode right;
    	TreeNode(int x){
    		val=x;
    	}
    }
    
    public static void main(String[] args) {
		TreeNode root = new TreeNode(2);
		root.left=new TreeNode(0);
		root.left.left=new TreeNode(-4);
		root.left.right=new TreeNode(1);
		root.right=new TreeNode(3);
		new Test13().findTarget(root, 3);
	}

}
