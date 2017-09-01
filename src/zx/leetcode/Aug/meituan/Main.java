package zx.leetcode.Aug.meituan;

import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int count = scanner.nextInt();
		int[] input = new int[count];
		for(int i=0;i<count;i++){
			input[i]=scanner.nextInt();
		}
		int k = scanner.nextInt();
		
		int maxLen = 0;
		for(int i=0;i<count;i++){
			int numI = input[i];
			if(numI%k==0)maxLen = Math.max(1, maxLen);
			int len = 0;
			int sum = numI;
			for(int j=i+1;j<count;j++){
				len++;
				sum+=input[j];
				if(sum%k==0){
					maxLen = Math.max(maxLen, len+1);
				}
			}
		}
		System.out.println(maxLen);
	}

}
