package zx.leetcode.dog.feb;

public class House_Robber_198 {
	
	/**
	 * 对于dp[i]有rob和unrob两种情况
	 * if rob    rob[i]=unrob[i-1]+nums[i]
	 * if unrob  unrob[i]=max(rob[i-1],unrob[i-1])
	 * 边界 
	 * rob[0] = nums[0]
	 * unrob[0] = 0;
	 * @param nums
	 * @return
	 */
	public int rob(int[] nums) {
		if(nums==null||nums.length==0){
			return 0;
		}
		int n = nums.length;
		int[] rob = new int[n+1];
		int[] unrob = new int[n+1];
		rob[0] = nums[0];
		unrob[0] = 0;
		for(int i=1;i<n;i++){
			rob[i] = unrob[i-1]+nums[i];
			unrob[i] = Math.max(rob[i-1], unrob[i-1]);
		}
        return Math.max(rob[n-1], unrob[n-1]);
    }
	
	public static void main(String[] args) {
		new House_Robber_198().rob(new int[]{});
	}

}
