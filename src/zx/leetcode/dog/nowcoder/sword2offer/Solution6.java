package zx.leetcode.dog.nowcoder.sword2offer;

public class Solution6 {
	
//	dp[i] = max(dp[i-1]+arr[i],arr[i])
	public int FindGreatestSumOfSubArray(int[] array) {
        int len = array.length;
        int max = Integer.MIN_VALUE;
        int[] dp = new int[len+1];
        dp[0] = array[0];
        for(int i=1;i<len;i++) {
        	dp[i] = Math.max(dp[i-1]+array[i], array[i]);
        	if(max<dp[i])max = dp[i];
        }
        return max;
    }
	
	public static void main(String[] args) {
		new Solution6().FindGreatestSumOfSubArray(new int[] {1,-2,3,10,-4,7,2,-5});
	}

}
