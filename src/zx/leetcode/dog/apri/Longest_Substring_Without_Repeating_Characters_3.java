package zx.leetcode.dog.apri;

import java.util.HashMap;
import java.util.Map;

public class Longest_Substring_Without_Repeating_Characters_3 {

	public int lengthOfLongestSubstring(String s) {
        if(s==null||s.length()==0) {
        	return 0;
        }		
        Map<Character,Integer> map = new HashMap<Character,Integer>();
        int max = 0;
        int leftBound = 0;
        for(int i=0;i<s.length();i++) {
        	char c = s.charAt(i);
        	leftBound = Math.max(leftBound, map.containsKey(c)?map.get(c)+1:0);
        	max = Math.max(max, i-leftBound+1);
        	map.put(c, i);
        }
        return max;
	}
	
	
	public static void main(String[] args) {
		new Longest_Substring_Without_Repeating_Characters_3().lengthOfLongestSubstring("abcabcaaa");
	}
	

}

