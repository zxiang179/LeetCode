package zx.leetcode.chicken.apri;

import java.util.TreeSet;

class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x){val=x;}
}
/**
 * 530. Minimum Absolute Difference in BST
 * @author Carl_Hugo
 */
public class Test11 {
    
	/**
	 * 中序遍历
	 * @param root
	 * @return
	 */
	int min = Integer.MAX_VALUE;
	Integer prev = null;
	/**
	 * inorder traverse the tree and compare the delta between each of the adjacent values
	 * @param root
	 * @return
	 */
	public int getMinimumDifference(TreeNode root) {
        if(root==null)return min;
        
        getMinimumDifference(root.left);
        if(prev!=null){
        	min = Math.min(min, root.val-prev);
        }
        prev=root.val;
        
        getMinimumDifference(root.right);
        
        return min;
    }
	
	/**
	 * put values into a treeSet every time we can use O(logN) time to lookfor the nearest values
	 * @param root
	 * @return
	 */
	TreeSet<Integer> set = new TreeSet<>();
	public int getMinimumDifference2(TreeNode root) {
		if(root==null)return min;
		//preorder
		if(!set.isEmpty()){
			//set.floor()返回此set中小于等于此元素的最大元素
			if(set.floor(root.val)!=null){
				min = Math.min(min, root.val-set.floor(root.val));
			}
			//set.ceiling()返回此set中大于等于此元素的最小元素
			if(set.ceiling(root.val)!=null){
				min = Math.min(set.ceiling(root.val)-root.val, min);
			}
		}
		set.add(root.val);
		getMinimumDifference2(root.left);
		getMinimumDifference2(root.right);
		return min;
		
	}

}
