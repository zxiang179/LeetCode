package zx.leetcode.june;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 513. Find Bottom Left Tree Value
 * @author Carl_Hugo
 * @date 2017年6月29日
 */
public class Test9 {
	
	/**
	 * level order traversal
	 * @param root
	 * @return
	 */
    public int findBottomLeftValue(TreeNode root) {
        if(root==null)return 0;
        int result=0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
        	int size = queue.size();
        	for(int i=0;i<size;i++){
        		TreeNode node = queue.poll();
        		if(i==0)result = node.val;
        		if(node.left!=null)queue.add(node.left);
        		if(node.right!=null)queue.add(node.right);
        	}
        }
        return result;
    }
    
    class TreeNode{
    	TreeNode left;
    	TreeNode right;
    	int val;
    	TreeNode(int x){
    		val = x;
    	}
    }

}
