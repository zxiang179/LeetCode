package zx.leetcode.chicken.july;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 524. Longest Word in Dictionary through Deleting
 * @author Carl_Hugo
 * @date 2017年7月10日
 */
public class Test16 {
	
	
	public String findLongestWord2(String s,List<String> d){
		String longest = "";
	    for (String dictWord : d) {
	        int i = 0;
	        for (char c : s.toCharArray()) 
	            if (i < dictWord.length() && c == dictWord.charAt(i)) i++;

	        if (i == dictWord.length() && dictWord.length() >= longest.length()) 
	            if (dictWord.length() > longest.length() || dictWord.compareTo(longest) < 0)
	                longest = dictWord;
	    }
	    return longest;
	}
    
	public String findLongestWord(String s, List<String> d) {
		int[] hash = new int[26];
		String[] satisfiedStr = new String[d.size()];
		int count = 0;
		boolean satisfied= true;
		for(int i=0;i<s.length();i++){
			hash[s.charAt(i)-'a']++;
		}
		for(int i=0;i<d.size();i++){
			int[] tempHash = new int[26];
			System.arraycopy(hash, 0,tempHash, 0, hash.length);
			String str = d.get(i);
			for(int j=0;j<str.length();j++){
				tempHash[str.charAt(j)-'a']--;
				if(tempHash[str.charAt(j)-'a']<0){
					satisfied=false;
					break;
				}
			}
			if(satisfied==true){
				satisfiedStr[count++]=str;					
			}
			satisfied=true;
		}
        if(count==0)return "";
        String longest =satisfiedStr[0];
        for(int i=1;i<satisfiedStr.length&&satisfiedStr[i]!=null;i++){
        	if(longest.length()<=satisfiedStr[i].length()){
        		if(longest.length()<satisfiedStr[i].length()||satisfiedStr[i].compareTo(longest)<0)
        		longest=satisfiedStr[i];
        	}
        }
        return longest;
    }
	
	public static void main(String[] args) {
		//"abpcplea"
		//["ale","apple","monkey","plea"]
		String[] str = {"aaa","aa","a"};
		List<String> list = Arrays.asList(str);
		new Test16().findLongestWord("aaa", list);
	}

}
