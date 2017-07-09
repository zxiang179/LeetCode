package zx.leetcode.july;
/**
 * 494. Target Sum
 * @author Carl_Hugo
 * @date 2017年7月8日
 */
public class Test13 {
	
	/**
	 * 
	 * @param nums
	 * @param S
	 * @return
	 */
    public int findTargetSumWays(int[] nums, int S) {
        int sum=0;
        for(int n:nums){
        	sum+=n;
        }
        return sum<S||(S+sum)%2>0?0:subsetSum(nums,(S+sum)>>>1);
    }
    
    public int subsetSum(int[] nums,int s){
    	int dp[] = new int[s+1];
    	dp[0]=1;
    	for(int n:nums){
    		for(int i=s;i>=n;i--){
    			dp[i]+=dp[i-n];
    		}
    	}
    	return dp[s];
    }

}
