package zx.leetcode.dog.mar;

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
    	if(matrix==null||matrix.length==0)return 0;
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
    
    public int maximalSquare2(char[][] matrix) {
    	if(matrix==null||matrix.length==0)return 0;
    	int m = matrix.length;
    	int n = matrix[0].length;
    	int[][] dp = new int[m][n];
    	int res = 0;
    	for(int i=0;i<m;i++){
    		if(matrix[i][0]=='1'){
    			dp[i][0] = 1;
    			res = 1;
    		}
    	}
    	for(int j=0;j<n;j++){
    		if(matrix[0][j]=='1'){
    			dp[0][j] = 1;
    			res = 1;
    		}
    	}
    	
    	for(int i=1;i<m;i++){
    		for(int j=1;j<n;j++){
				if(matrix[i][j]=='1'){
    				dp[i][j] = Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i][j-1]))+1;
    			}	
    			if(res<dp[i][j])res = dp[i][j];
    		}
    	}
	    return res*res;
	}
    
    public static void main(String[] args) {
	}

}
