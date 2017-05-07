package zx.leetcode.may;
/**
 * 108. Convert Sorted Array to Binary Search Tree
 * @author Carl_Hugo
 * @date 2017年5月7日
 */
public class Test14 {
	
	/**
	 * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
	 * @param nums
	 * @return
	 */
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length==0)return null;
        return treeNodeHelper(nums,0,nums.length-1);
    }
    
    public TreeNode treeNodeHelper(int[] nums,int left,int right){
    	if(left>right)return null;
    	int mid = (left+right)/2;
    	TreeNode node =new TreeNode(nums[mid]);
    	node.left=treeNodeHelper(nums,left,mid-1);
    	node.right=treeNodeHelper(nums,mid+1,right);
    	return node;
    }
}

