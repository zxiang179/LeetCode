package zx.leetcode.Sep.jd;

import java.util.Scanner;

public class Test2 {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String str = scanner.nextLine();
		String[] arr = new String[str.length()];
		if(str.length()<2)System.out.println(0);
		for(int i=0;i<str.length();i++){
			Character c = str.charAt(i);
			arr[i]=c.toString();
		}
		System.out.println();
	}
	
	

}
