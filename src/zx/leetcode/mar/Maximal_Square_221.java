package zx.leetcode.mar;

public class Maximal_Square_221 {
	
	/**
	 * dp[i][j]表示到达i、j位置能够组成的最大正方形的位置
	 * 
	 * 边界
	 * dp[0][j]=1 if(matrix[0][j]==1) for(j=0;j<matrix[0].length;j++)
	 * dp[i][0]=1 if(matrix[i][0]==1) for(i=0;i<matrix.length;i++)
	 * 
	 * 状态转移方程
	 * dp[i][j] = 0 if(matrix[i][j]==0)
	 * dp[i][j] = min(dp[i-1][j-1],dp[i-1][j],dp[i][j-1])+1
	 * @param matrix
	 * @return
	 */
    public int maximalSquare(char[][] matrix) {
    	int m = matrix.length;
    	int n = matrix[0].length;
    	int[][] dp = new int[m][n];
    	int res = 0;
    	for(int i=0;i<m;i++){
    		for(int j=0;j<n;j++){
    			if(i==0||j==0){
    				if(matrix[i][j]=='1')dp[i][j] = 1;
    			}else{
    				if(matrix[i][j]=='1'){
        				dp[i][j] = Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i][j-1]))+1;
        			}	
    			}
    			if(res<dp[i][j])res = dp[i][j];
    		}
    	}
	    return res*res;
	}
    
    public static void main(String[] args) {
	}

}
