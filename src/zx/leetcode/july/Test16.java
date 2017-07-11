package zx.leetcode.july;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 524. Longest Word in Dictionary through Deleting
 * @author Carl_Hugo
 * @date 2017年7月10日
 */
public class Test16 {
	
    
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
				}
			}
			if(satisfied==true){
				satisfiedStr[count++]=str;					
			}
		}
        if(count==0)return "";
        Arrays.sort(satisfiedStr);
        return satisfiedStr[0];
    }
	
	public static void main(String[] args) {
		//"abpcplea"
		//["ale","apple","monkey","plea"]
		String[] str = {"ale","apple","monkey","plea"};
		List<String> list = Arrays.asList(str);
		new Test16().findLongestWord("abpcplea", list);
	}

}
