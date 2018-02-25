package zx.leetcode.dog.feb;

import java.util.Scanner;

/**
 * @author Carl_Hugo
 * 2018年2月25日 上午10:28:34
 */
public class FindLongestPalindrome {
	
	public static void main(String[] args) {
//		Scanner scanner = new Scanner(System.in);
//		String inputStr = scanner.nextLine();
		String inputStr = "asdffdsasdfsdfsdffdsfdsfdsa";
		int length = inputStr.length();
		int maxLen = 0;
		int start = 0;
		boolean[][] dp = new boolean[50][50]; 
		for(int i=0;i<length;i++){
			dp[i][i] = true;
			if(i<length-1&&inputStr.charAt(i)==inputStr.charAt(i+1)){
				dp[i][i+1] = true;
				start = i;
				maxLen = 2;
			}
		}
		
		for(int len = 3;len<length;len++){//子串长度
			for(int i=0;i<=length-len;i++){//子串起始的地址
				int j = i+len-1;//子串结束位置
				if(dp[i+1][j-1]==true&&inputStr.charAt(i)==inputStr.charAt(j)){
					dp[i][j]=true;
					maxLen = len;
					start = i;
					if(maxLen>=5){
						System.out.println(inputStr.substring(start, start+maxLen));
					}
				}
			}			
		}
	}

}
