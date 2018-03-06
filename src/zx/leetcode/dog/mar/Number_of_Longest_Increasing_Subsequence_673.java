package zx.leetcode.dog.mar;

import java.util.Arrays;

public class Number_of_Longest_Increasing_Subsequence_673 {
	
	/**
	 * dp[i] 表示到数组第i个位置的最长上升子序列的长度
	 * cnt[i] 表示到数组第i个位置的最长上升子序列的长度的情况的数量
	 * 
	 * 边界
	 * dp[0]=1
	 * cnt[0]=1
	 * 
	 * 状态转移方程
	 * dp[i] = max(dp[j]+1,dp[i])  if(nums[i]>nums[j])  0<j<i
	 * 
	 *   if(dp[j]+1>dp[i]) cnt[i] = cnt[j]
	 *   if(dp[j]+1==dp[i]) cnt[i] +=cnt[j]
	 * 
	 * @param nums
	 * @return
	 */
	public int findNumberOfLIS(int[] nums) {
		if(nums==null||nums.length==0)return 0;
        int n = nums.length;
        int[] dp = new int[n];
        int[] cnt = new int[n];
        int max = 1;
        int res = 0;
        for(int i=0;i<n;i++){
        	dp[i] = 1;
        	cnt[i] = 1;
        	for(int j=0;j<i;j++){
        		if(nums[i]>nums[j]){
        			if(dp[j]+1>dp[i]){
        				dp[i] = dp[j] + 1;
            			cnt[i] = cnt[j];
        			}else if(dp[j]+1==dp[i]){
        				cnt[i] += cnt[j];
        			}
        		}
        		max = Math.max(dp[i], max);
        	}
        }
		for(int i=0;i<nums.length;i++){
			if(dp[i]==max)res+=cnt[i];
		}
		return res;
    }
	
	public static void main(String[] args) {
		new Number_of_Longest_Increasing_Subsequence_673().findNumberOfLIS(new int[]{1,3,5,4,7});
	}

}
