package zx.leetcode.chicken.Aug;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 501. Find Mode in Binary Search Tree
 * @author Carl_Hugo
 * @date 2017年8月19日
 */
public class Test14 {
	
	Integer prev = null;
	int count = 1;
	int max = 0;
	
	/**
	 * fing the most frequently occurred element) in the given BST
	 * @param root
	 * @return
	 */
    public int[] findMode(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        inOrderTraversal(root,list);
    	int[] res = new int[list.size()];
    	for(int i=0;i<list.size();i++){
    		res[i]=list.get(i);
    	}
    	return res;
    }
    
    public void inOrderTraversal(TreeNode root,List<Integer> list){
    	if(root==null)return;
    	if(root.left!=null)inOrderTraversal(root.left,list);
    	if(prev!=null){
    		if(prev==root.val){
    			count++;
    		}else{
    			count=1;
    		}
    	}
    	if(count>max){
    		max = count;
    		list.clear();
    		list.add(root.val);
    	}else if(count==max){
    		list.add(root.val);
    	}
    	prev = root.val;
    	if(root.right!=null)inOrderTraversal(root.right,list);
    }
    
    static class TreeNode{
    	int val;
    	TreeNode left;
    	TreeNode right;
    	TreeNode(int x){
    		val = x;
    	}
    }

}
