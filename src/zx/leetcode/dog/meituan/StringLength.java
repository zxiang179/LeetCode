package zx.leetcode.dog.meituan;

import java.util.Scanner;

public class StringLength {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String S = scanner.nextLine();
		String T = scanner.nextLine();
		int count = 0;
		int index = 0;
		
		for(int j=0;j<T.length();j++){
			for(int i=0;i< T.length()-j;i++){}
			
		}
		/*for(;index<=S.length()-T.length();){
			i = index;
			for(int j=0;j<T.length();j++){
				if(S.charAt(i++)!=T.charAt(j)){
					count++;
				}
			}
			index++;
		}
		System.out.println(count);*/
	}
	

}
