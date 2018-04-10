package zx.leetcode.dog.apri.zhaoshangyinghang;

import java.util.HashSet;
import java.util.Scanner;

public class Main1 {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String inputStr = scanner.nextLine();
		String[] split = inputStr.split("\\s");
		int n = Integer.valueOf(split[0]);
		HashSet<Integer> set = new HashSet<Integer>();
		for(int i=1;i<split.length;i++) {
			set.add(Integer.valueOf(split[i]));
		}
		for(int i=0;i<=n;i++) {
			if(set.contains(i)==false) {
				System.out.println(i);
			}
		}
	}

}
