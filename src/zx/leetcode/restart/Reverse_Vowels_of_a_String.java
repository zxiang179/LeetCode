package zx.leetcode.restart;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Reverse_Vowels_of_a_String {
	
	public String reverseVowels(String s) {
		char[] charArr = s.toCharArray();
		Set<Character> vowelSet = new HashSet<Character>(Arrays.asList('a','e','i','o','u','A','E','I','O','U'));
		int i = 0;
		int j = charArr.length-1;
		
		while(i<=j){
			while(i<=j&&!vowelSet.contains(charArr[i]))i++;
			while(i<=j&&!vowelSet.contains(charArr[j]))j--;
			
			if(i<=j){
				char c = charArr[i];
				charArr[i] = charArr[j];
				charArr[j] = c;
				i++;
				j--;
			}
		}
		
		return new String(charArr);
	}

}
