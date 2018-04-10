package zx.leetcode.dog.apri.zhaoshangyinghang;

import java.util.Arrays;
import java.util.Scanner;

public class Main2 {
	
	/**
	 * dp[0] = 0
	 * dp[1] = 1
	 * dp[2] = 2
	 * dp[i] = min(dp[i-1]+1,if(i%2==0){dp[i/2]+1}else{dp[i/2]+2},dp[i+1]-1)
	 * @param args
	 */
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int x = scanner.nextInt();
		int[] dp = new int[x+2];
	    Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;
		if(x==0) {
			System.out.println(0);
		}else {
			dp[1] = 1;
			int count = 2;
			for(int i=2;i<=x;i = i*2) {
				dp[i] = count++;
			}
			for(int i=3;i<=x;i++) {
				dp[i] = Math.min(dp[i-1], dp[i+1])+1;
				if(i%2==0) {
					dp[i] = Math.min(dp[i], dp[i/2]+1);
				}else {
					dp[i] = Math.min(dp[i], dp[i/2]+2);
				}
			}
			System.out.println(dp[x]);
		}
	}

}
