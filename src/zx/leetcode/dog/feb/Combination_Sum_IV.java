package zx.leetcode.dog.feb;

public class Combination_Sum_IV {
	
	/**
	 * dp[target]=sum(dp[target-nums[i]])for(i=0;i<nums.length;i++)
	 * 
	 * @param nums
	 * @param target
	 * @return
	 */
	public int combinationSum4(int[] nums, int target) {
		int[] dp = new int[target+1];
		for(int i=0;i<=target;i++){
			for(int k=0;k<nums.length;k++){
				if(i-nums[k]>0){
					dp[i] += dp[i-nums[k]];
				}else if(i-nums[k]==0){
					dp[i] += 1;
				}
			}
		}
		return dp[target];
    }

	public static void main(String[] args) {
		new Combination_Sum_IV().combinationSum4(new int[]{1,2,3}, 4);
	}
	
}
