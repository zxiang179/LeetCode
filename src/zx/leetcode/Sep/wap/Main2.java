package zx.leetcode.Sep.wap;

import java.util.Scanner;
/**
 * coin game
 * @author Carl_Hugo
 * 2017年10月13日 下午7:18:21
 */
public class Main2 {
	
	public static void main(String[] args) {
		//input
		Scanner scanner = new Scanner(System.in);
		String firstLine = scanner.nextLine();
		int sum = 0;
		
		String[] split = firstLine.split("\\s");
		int n = Integer.valueOf(split[0]);
		int m = Integer.valueOf(split[1]);
		int[][] arr = new int[n][m];
		
		for(int i=0;i<n;i++){
			String strLine = scanner.nextLine();
			for(int j=0;j<m;j++){
				char c = strLine.charAt(j);
				if(c=='.')arr[i][j]=0;
				if(c=='o'){
					arr[i][j]=1;
					sum++;
				}
			}
		}
		int k = Integer.valueOf(scanner.nextLine());
		if(sum<k)System.out.println(-1);
		if(sum==k)System.out.println(0);
		
		
	}

}
