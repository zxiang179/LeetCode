package zx.leetcode.chicken.restart;

import org.junit.Test;

public class Longest_Palindrome {
	
	public int longestPalindrome(String s) {
		//a~z A~Z
		int[] hash = new int[52];
		boolean addExtraOne = false;
		int count = 0;
		for(int i=0;i<s.length();i++){
			char c = s.charAt(i);
			if(c>='a'&&c<='z'){
				hash[c-'a']++;	
			}else if(c>='A'&&c<='Z'){
				hash[c-'A'+26]++;
			}
			
		}
		
		for(int i=0;i<52;i++){
			if((hash[i]&1)==0){
				count+=hash[i];
			}else{
				addExtraOne = true;
				count+=hash[i]-1;
			}
		}
        return (addExtraOne==true?1:0)+count;
    }

	@Test
	public void test(){
		longestPalindrome("AAAAAA");
	}

}
