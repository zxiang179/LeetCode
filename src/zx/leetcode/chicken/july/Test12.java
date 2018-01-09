package zx.leetcode.chicken.july;
/**
 * 416. Partition Equal Subset Sum
 * @author Carl_Hugo
 * @date 2017年7月8日
 */
public class Test12 {

	/**
	 * find if the array can be partitioned into two subsets 
	 * such that the sum of elements in both subsets is equal.
	 * @param nums
	 * @return
	 */
    public boolean canPartition(int[] nums) {
    	if(nums==null||nums.length==0){
    		return false;
    	}
    	int sum = 0;
    	for(int n:nums){
    		sum+=n;
    	}
    	if(sum%2==1)return false;
    	int volumn = sum/2;
    	//dp
    	boolean[] dp = new boolean[volumn+1];
    	dp[0]=true;
    	for(int i=1;i<=nums.length;i++){
    		for(int j=volumn;j>=nums[i-1];j--){
    			dp[j] = dp[j]||dp[j-nums[i-1]];
    		}
    	}
        return dp[volumn];
    }
	
    public static void main(String[] args) {
		new Test12().canPartition(new int[]{1, 5, 11, 5});
	}

}
