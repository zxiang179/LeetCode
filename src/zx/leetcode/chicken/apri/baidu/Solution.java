package zx.leetcode.chicken.apri.baidu;

import java.util.Arrays;


public class Solution {

	//dp[i] = min(dp[i-k] + dp[k],dp[i])
	public int[] maxRestTime(int numCities, 
							int numRoads,
							int[][] travelTime, 
							int numDeliveries, 
							int[][] timeLimit) {
		 
		int[] dp = new int[numCities+1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[1] = 0;
		for(int i=0;i<numRoads;i++) {
			if(travelTime[i][0]>travelTime[i][1]) {
				int temp = travelTime[i][0];
				travelTime[i][0] = travelTime[i][1];
				travelTime[i][1] = temp;
			}
			if(travelTime[i][0]==1) {
				dp[travelTime[i][1]] = travelTime[i][2]; 
			} 
		}
		
		for(int i=0;i<numRoads;i++) {
			dp[travelTime[i][1]] = Math.min(dp[travelTime[i][1]], dp[travelTime[i][0]]+travelTime[i][2]);
		}
		
		int[] timeLeft = new int[numDeliveries];
		for(int i=0;i<numDeliveries;i++) {
			if(dp[timeLimit[i][0]]*2<=timeLimit[i][1]) {
				timeLeft[i] = timeLimit[i][1] - dp[timeLimit[i][0]]*2; 
			}
		}
		return timeLeft;
	}
	
	public static void main(String[] args) {
		new Solution().maxRestTime(4, 4, new int[][] {{1,2,5},{2,3,10},{3,4,20},{1,4,1}}, 2, new int[][] {{2,65},{3,15}});
	}

}
