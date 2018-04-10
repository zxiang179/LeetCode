package zx.leetcode.dog.apri.zhaoshangyinghang;

import java.util.Scanner;

public class Main3 {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		if(n==0) {
			System.out.println(0);	
		}else {
			int[] uNums = new int[n];
			uNums[0] = 1;
			int f2 = 2;
			int f3 = 3;
			int f5 = 5;
			int idx2 = 0;
			int idx3 = 0;
			int idx5 = 0;
			for(int i=1;i<n;i++){
				int min = Math.min(f2, Math.min(f3, f5));
				uNums[i] = min;
				if(min==f2){
					f2 = 2*uNums[++idx2];
				}
				if(min==f3){
					f3 = 3*uNums[++idx3];
				}
				if(min==f5){
					f5 = 5*uNums[++idx5];
				}
			}
			System.out.println(uNums[n-1]);
		}
	}

}
