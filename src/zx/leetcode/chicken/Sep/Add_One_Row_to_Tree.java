package zx.leetcode.chicken.Sep;
/**
 * 623. Add One Row to Tree
 * @author Carl_Hugo
 * @date 2017年9月1日
 */
public class Add_One_Row_to_Tree {
	
    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if(d==1){
        	TreeNode newRoot = new TreeNode(v);
        	root.left = newRoot;
        	return newRoot;
        }
        add(root,v,d,1);
        return root;
    	
    }
    
    public void add(TreeNode root,int v,int d,int currentDepth){
    	if(root==null){
    		return;
    	}
    	if(currentDepth==d-1){
    		TreeNode temp = root.left;
    		root.left=new TreeNode(v);
    		root.left.left=temp;
    		
    		temp = root.right;
    		root.right=new TreeNode(v);
    		root.right.right=temp;
    	    return;
    	}
    	add(root.left,v,d,currentDepth+1);
    	add(root.right,v,d,currentDepth+1);
    	
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
