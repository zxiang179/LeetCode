package zx.leetcode.chicken.apri;

import java.util.HashMap;
import java.util.Map;

/**
 * 387. First Unique Character in a String
 * @author Carl_Hugo
 */
public class Test17 {

	/**
	 * s = "leetcode"
     * return 0.
     * s = "loveleetcode",
     * return 2.
	 * @param s
	 * @return
	 */
	public int firstUniqChar(String s) {
        Map<Character,Integer> map = new HashMap<Character,Integer>();
        char[] charArray = s.toCharArray();
        int index = -1;
        for(int i=0;i<charArray.length;i++){
        	if(map.get(charArray[i])==null){
        		map.put(charArray[i], 1);
        	}else{
        		map.put(charArray[i], map.get(charArray[i])+1);
        	}
        }
        for(int i=0;i<charArray.length;i++){
        	if(map.get(charArray[i])==1){
        		index = i;
        		break;
        	}
        }
        return index;
    }
	
	public int firstUniqueChar2(String s){
		int freq[] = new int[26];
		for(int i=0;i<s.length();i++){
			freq[s.charAt(i)-'a']++;
		}
		for(int i=0;i<s.length();i++){
			if(freq[s.charAt(i)-'a']==1)
				return i;
		}
		return -1;
	}
	
	public static void main(String[] args) {
		Test17 test17 = new Test17();
		System.out.println(test17.firstUniqChar("loveleetcode"));
	}
}
