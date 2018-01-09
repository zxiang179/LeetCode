package zx.leetcode.chicken.Sep.iqiyi;

import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String inputStr = scanner.nextLine();
		int minusCount = 0;
		int count = 0;
		int[] hash = new int[26];
		for(int i=0;i<inputStr.length();i++){
			hash[inputStr.charAt(i)-'a']++;
		}
		for(int i=0;i<26;i++){
			if(hash[i]%2!=0){
				minusCount++;
			}
			count+=hash[i];
		}
		System.out.println(count-minusCount);
	}

}
