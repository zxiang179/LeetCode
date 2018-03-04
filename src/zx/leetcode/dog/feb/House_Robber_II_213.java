package zx.leetcode.dog.feb;

import java.util.Arrays;

public class House_Robber_II_213 {
	
	/**
	 * 对于一户人家有rob和unrob两种情况
	 * 
	 * 状态转移方程
	 * rob[i] = unrob[i-1]+nums[i]
	 * unrob[i] = max(rob[i-1],unrob[i-1])
	 * 
	 * 边界
	 * 分别求两种情况
	 * 1. 抢第一家，不抢最后一家
	 * rob[0] = nums[0]
	 * unrob[0] = 0
	 * 2. 抢第二家，抢最后一家
	 * rob[1] = nums[1]
	 * unrob[1] = 0
	 * @param nums
	 * @return
	 */
	public int rob(int[] nums) {
		int n = nums.length;
		if(nums==null||nums.length==0)return 0;
		if(n<2)return nums[0];
		int[] rob = new int[n];
		int[] unrob = new int[n];
		int res = 0;
		//第一种情况，抢第一家不抢最后一家
		rob[0] = nums[0];
		unrob[0] = 0;
		for(int i=1;i<n-1;i++){
			rob[i] = unrob[i-1]+nums[i];
			unrob[i] = Math.max(rob[i-1],unrob[i-1]);
		}
		res = Math.max(rob[n-2], unrob[n-2]);
		
		Arrays.fill(rob, 0);
		Arrays.fill(unrob, 0);
		
		//第一种情况，抢第二家抢最后一家
		rob[1] = nums[1];
		unrob[1] = 0;
		for(int i=2;i<n;i++){
			rob[i] = unrob[i-1]+nums[i];
			unrob[i] = Math.max(rob[i-1],unrob[i-1]);
		}
		res = Math.max(res, Math.max(rob[n-1], unrob[n-1]));
		
		return res;
    }
	
	public static void main(String[] args) {
		new House_Robber_II_213().rob(new int[]{});
	}

}

