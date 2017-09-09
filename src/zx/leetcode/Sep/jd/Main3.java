package zx.leetcode.Sep.jd;

import java.util.Scanner;

public class Main3 {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int count = 0;
		for(int a=1;a<=n;a++){
			for(int b=1;b<=n;b++){
				for(int c=1;c<=n;c++){
					for(int d=1;d<=n;d++){
						if(Math.pow(a, b)==Math.pow(c, d)){
							count++;
						}
					}
				}
			}
		}
		System.out.println(count);
	}

}
