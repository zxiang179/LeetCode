package zx.leetcode.chicken.july;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 337. House Robber III
 * @author Carl_Hugo
 * @date 2017年7月7日
 */
public class Test11 {
	
	public int rob(TreeNode root) {
		if(root==null)return 0;
		return Math.max(nodeInclude(root), nodeExclude(root));
	}
	
	public int nodeInclude(TreeNode node){
		if(node==null)return 0;
		return nodeExclude(node.left)+nodeExclude(node.right)+node.val;
	}
	
	public int nodeExclude(TreeNode node){
		if(node==null)return 0;
		return rob(node.left)+rob(node.right);
	}
	
    public int rob2(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        //记录每一层数之和
        ArrayList levelSumList = new ArrayList();
        int sum1 = 0;
        int sum2 = 0;
        if(root==null)return 0;
        
        queue.add(root);
        
        while(!queue.isEmpty()){
        	int size = queue.size();
        	int tempSum = 0;
        	for(int i=0;i<size;i++){
        		TreeNode node = queue.poll();
        		int val = node.val;
        		tempSum +=val;
        		if(node.left!=null)queue.add(node.left);
        		if(node.right!=null)queue.add(node.right);
        	}
        	levelSumList.add(tempSum);
        }
        int rob=0;
        int notrob=0;
        for(int i=0;i<levelSumList.size();i++){
        	//当前如果抢劫
        	int currob = notrob+(int)levelSumList.get(i);
        	notrob = Math.max(notrob, rob);
        	rob = currob;
        }
        
        return Math.max(notrob, rob);
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
