package zx.leetcode.chicken.Aug;
/**
 * 654. Maximum Binary Tree
 * @author Carl_Hugo
 * @date 2017年8月20日
 */
public class Test15 {

	public TreeNode constructMaximumBinaryTree(int[] nums) {
	    if(nums.length==0||nums==null)return null;
	    return subConstruct(nums,0,nums.length-1);
	}
	
	public static TreeNode subConstruct(int[] nums,int start,int end){
		if(start>end)return null;
		int max = Integer.MIN_VALUE;
		int index = 0;
		for(int i=start;i<=end;i++){
			if(max<nums[i]){
				max = nums[i];
				index = i;
			}
		}
		TreeNode root = new TreeNode(max);
		root.left = subConstruct(nums,start,index-1);
		root.right = subConstruct(nums, index+1, end);
		return root;
	} 
	
	static class TreeNode{
		TreeNode left;
		TreeNode right;
		int val;
		TreeNode(int x){
			val = x;
		}
	}
	
}
