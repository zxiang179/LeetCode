package zx.leetcode.dog.feb;

import java.util.ArrayList;
import java.util.List;


public class Triangle_87 {
	
	/**
	 * dp[i][j]表示到i行j列最短的路径之和
	 * 
	 * 边界
	 * dp[i][0] = dp[i-1][0] + triangle[i][0]
	 * dp[i][i] = dp[i-1][i-1] + triangle[i][i]
	 * 
	 * 状态转移方程
	 * dp[i][j] = min(dp[i-1][j-1],dp[i-1][j])+triangle[i][j]
	 * 
	 *  
	 * @param triangle
	 * @return
	 */
	public int minimumTotal(List<List> triangle) {
		int m = triangle.size();
		int n = triangle.get(m-1).size();
		int[][] dp = new int[m][n];
		dp[0][0] = (int)triangle.get(0).get(0);
		for(int i=1;i<m;i++){
			dp[i][0] = dp[i-1][0] + (int)triangle.get(i).get(0);
			dp[i][i] = dp[i-1][i-1] + (int)triangle.get(i).get(i);
		}
		
		for(int i=1;i<m;i++){
			for(int j=1;j<triangle.get(i).size()-1;j++){
				dp[i][j] = Math.min(dp[i-1][j-1],dp[i-1][j])+(int)triangle.get(i).get(j);
			}
		}
		
		int min = dp[m-1][0];
		for(int j=0;j<n;j++){
			if(dp[m-1][j]<min)min = dp[m-1][j];
		}
		return min;
    }
	
	public static void main(String[] args) {
		ArrayList list = new ArrayList();
		ArrayList sublist1 = new ArrayList();
		sublist1.add(-1);
		ArrayList sublist2 = new ArrayList();
		sublist2.add(3);
		sublist2.add(2);
		ArrayList sublist3 = new ArrayList();
		sublist3.add(1);
		sublist3.add(-2);
		sublist3.add(-1);
		list.add(sublist1);
		list.add(sublist2);
		list.add(sublist3);
		new Triangle_87().minimumTotal(list);
	}

}
