package zx.leetcode.Aug;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 508. Most Frequent Subtree Sum
 * @author Carl_Hugo
 * @date 2017年8月29日
 */
public class Most_Frequent_Subtree_Sum {
	
	Map<Integer,Integer> map = null;
	int maxCount = Integer.MIN_VALUE;
	
	/**
	 * @param root
	 * @return
	 */
    public int[] findFrequentTreeSum(TreeNode root) {
    	map = new HashMap<Integer,Integer>();
        List<Integer> resList = new ArrayList<Integer>();
        
        postOrder(root);
        for(int key:map.keySet()){
        	if(map.get(key)==maxCount){
        		resList.add(key);
        	}
        }
        int[] resArr = new int[resList.size()];
        for(int i=0;i<resList.size();i++){
        	resArr[i]=resList.get(i);
        }
    	return resArr;
    }
    
    public int postOrder(TreeNode root){
    	if(root==null)return 0;
    	int leftVal = postOrder(root.left);
    	int rightVal = postOrder(root.right);
    	int sum = leftVal+rightVal+root.val;
        int count = map.getOrDefault(sum, 0)+1;
    	map.put(sum, count);
    	maxCount = Math.max(maxCount, count);
        return sum;
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
