package zx.leetcode.Sep;

import java.util.Arrays;

/**
 * 646. Maximum Length of Pair Chain
 * @author Carl_Hugo
 * @date 2017年9月1日
 */
public class Maximum_Length_of_Pair_Chain {
	
    public int findLongestChain(int[][] pairs) {
    	if(pairs == null || pairs.length==0)return 0;
    	Arrays.sort(pairs, (a,b)->(a[0]-b[0]));
    	int[] dp = new int[pairs.length];
    	Arrays.fill(dp, 1);
    	for(int i=0;i<dp.length;i++){
    		for(int j=0;j<i;j++){
    			dp[i] = Math.max(dp[i], pairs[i][0]>pairs[j][1]?dp[j]+1:dp[j]);
    		}
    	}
        return dp[pairs.length-1];
    }
    
    public static void main(String[] args) {
		new Maximum_Length_of_Pair_Chain().findLongestChain(new int[][]{{1,2}, {2,3}, {3,4}});
	}

}
