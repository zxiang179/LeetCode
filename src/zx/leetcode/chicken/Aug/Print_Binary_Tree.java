package zx.leetcode.chicken.Aug;

import java.util.ArrayList;
import java.util.List;

/**
 * 655. Print Binary Tree
 * @author Carl_Hugo
 * @date 2017年8月30日
 */
public class Print_Binary_Tree {
	
    public List<List<String>> printTree(TreeNode root) {
    	List<List<String>> resList = new ArrayList<>();
        int height = root==null?1:getHeight(root);
        int rows = height;
        int columns = (int)Math.pow(2, height)-1;
        List<String> row = new ArrayList<String>();
        for(int i=0;i<columns;i++)row.add("");
        for(int i=0;i<rows;i++)resList.add(new ArrayList<>(row));
        func(root,resList,0,rows,0,columns-1);
        return resList;
    }
    
    public void func(TreeNode root,List<List<String>> res,int row,int totalRows,int i,int j){
    	if(row==totalRows||root==null)return;
    	res.get(row).set((i+j)/2, Integer.toString(root.val));
    	func(root.left,res,row+1,totalRows,i,(i+j)/2-1);
    	func(root.right,res,row+1,totalRows,(i+j)/2+1,j);
    }
    
    public int getHeight(TreeNode root){
    	if(root==null)return 0;
    	return Math.max(getHeight(root.left), getHeight(root.right))+1;
    }
    
    class TreeNode{
    	TreeNode left;
    	TreeNode right;
    	int val;
    	TreeNode(int x){
    		val=x;
    	}
    }

}
