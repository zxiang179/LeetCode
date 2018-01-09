package zx.leetcode.chicken.apri;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 438. Find All Anagrams in a String
 * @author Carl_Hugo
 * https://leetcode.com/problems/find-all-anagrams-in-a-string/#/solutions
 */
public class Test22 {
	
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> resList = new ArrayList<Integer>();
        if(s.length()==0||s==null||p.length()==0||p==null)return resList;
        int left=0;
        int right=0;
        int count = p.length();
        int[] hash = new int[256];
        for(int c:p.toCharArray()){
        	hash[c]++;
        }
        while(right<s.length()){
        	if(hash[s.charAt(right++)]-->=1)count--;
        	if(count==0)resList.add(left);
        	if(right-left==p.length()&&hash[s.charAt(left++)]++>=0)count++;
        }
        return resList;
    }
    
    public static void main(String[] args) {
		Test22 test22 = new Test22();
		System.out.println(test22.findAnagrams("abab", "ab"));
	}

}
