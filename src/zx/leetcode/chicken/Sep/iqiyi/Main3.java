package zx.leetcode.chicken.Sep.iqiyi;

import java.util.Scanner;

public class Main3 {
	
	public static void main(String[] args) {
		int maxn =(int) (1e5+7);
		int[] vis = new int[maxn];
		int[] num = new int[maxn];
        for(int i=1;i*i<maxn;i++){
        	vis[i*i]=1;
        }
        num[0]=0;
		for(int i=1;i<maxn;i++){
			num[i]=num[i-1];
			if(vis[i]==1)num[i]++;
		}
		int n,m;
		
		Scanner scanner = new Scanner(System.in);
		String string = scanner.nextLine();
		String[] split = string.split("\\s");
		n = Integer.valueOf(split[0]);
		m = Integer.valueOf(split[1]);
		
		System.out.println(num[n]+num[m]+Math.min(n, m)-num[Math.min(n, m)]);
	}

}
