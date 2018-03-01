package zx.leetcode.dog.feb;

public class Longest_Increasing_Subsequence_300 {
	
	/**
	 * 求最长递增自序列
	 * dp[i]表示当前索引的最长递增子序列的长度
	 * dp[i]=dp[i] if(nums[i]<nums[j],i>j)
	 * dp[i]=dp[j]+1 if(nums[i]>nums[j]&&dp[i]<dp[j]+1)
	 * 边界dp[0]=0,dp[1]=1
	 * @param nums
	 * @return
	 */
	public int lengthOfLIS(int[] nums) {
		if(nums==null||nums.length==0)return 0;
		int n = nums.length;
		int[] dp = new int[n+1];
		int max = 0;
		for(int i=0;i<n;i++){
			//每个子问题最短也为1
			dp[i]=1;
			for(int j=0;j<i;j++){
				if(nums[i]>nums[j]&&dp[i]<dp[j]+1){
					dp[i] = dp[j] + 1;
				}
			}
			if(dp[i]>max)max = dp[i];
		}
		return max;
    }
	
	public static void main(String[] args) {
		new Longest_Increasing_Subsequence_300().lengthOfLIS(new int[]{1,3,6,7,9,4,10,5,6});
	}
}
