package zx.leetcode.dog.feb;

public class Unique_Binary_Search_Trees_96 {
	
	/**
	 * 知识铺垫：
	 * 1.二叉搜索树中的任意一个节点都可以作为根
	 * 2.二叉搜索树的形态等于左子树的形态数*右子树的形态的数量
	 * 3.空树也为二叉搜索树
	 * 边界：
	 * dp[0]=1、dp[1]=1、
	 * 状态转移方程
	 * dp[i]= sum(dp[i-k]*dp[k-1]) for(int k=1;k<i;k++)以k为根节点
	 * @param n
	 * @return
	 */
	public int numTrees(int n) {
        int[] dp = new int[n+1];
        dp[0]=1;
        dp[1]=1;
        for(int i=2;i<=n;i++){
        	for(int k=1;k<=i;k++){
            	dp[i] += dp[i-k]*dp[k-1];	
            }	
        }
        return dp[n];
    }

	public static void main(String[] args) {
		new Unique_Binary_Search_Trees_96().numTrees(3);
	}
	
}
