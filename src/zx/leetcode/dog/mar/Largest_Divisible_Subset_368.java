package zx.leetcode.dog.mar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Largest_Divisible_Subset_368 {
	
	/**
	 * dp[i] 表示数组从0~i 最长可划分的子序列的长度
	 * 
	 * 边界
	 * dp[0] = 1
	 * 
	 * 状态转移方程
	 * dp[i] = dp[j]+1 if(nums[i]%nums[j]==0&&dp[i]<dp[j]+1)    nums[] 从小到大排序
	 * 
	 * @param nums
	 * @return
	 */
	public List<Integer> largestDivisibleSubset(int[] nums) {
		if(nums==null||nums.length==0)return new ArrayList<Integer>();
		int n = nums.length;
		Arrays.sort(nums);
		List<Integer> resList = new ArrayList<Integer>();
		if(n==1){
			resList.add(nums[0]);
			return resList;
		}
		int[] dp = new int[n];
		int maxLen = 0;
		int maxIndex = 0;
		for(int i=0;i<n;i++){
			for(int j=0;j<i;j++){
				if(nums[i]%nums[j]==0){
					if(dp[i]<dp[j]+1){
						dp[i] = dp[j]+1;
						if(dp[i]>maxLen){
							maxLen = dp[i];
							maxIndex = i;
						}
					}
				}
			}
		}

		for(int i=0;i<=maxLen;i++){
			for(int j=0;j<n;j++){
				if(dp[j]==i){
					resList.add(nums[j]);	
					break;
				}
			}
		}
        return resList;
    }
	
	public static void main(String[] args) {
		new Largest_Divisible_Subset_368().largestDivisibleSubset(new int[]{4,8,10,240});
	}

}
