package zx.leetcode.chicken.apri;

import java.util.HashSet;
import java.util.Set;

/**
 * 383. Ransom Note
 * @author Carl_Hugo
 */
public class Test19 {
	
	/**
	 * canConstruct("a", "b") -> false
     * canConstruct("aa", "ab") -> false
     * canConstruct("aa", "aab") -> true
	 * @param ransomNote
	 * @param magazine
	 * @return
	 */
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] map = new int[26];
        for(int i=0;i<magazine.length();i++){
        	map[magazine.charAt(i)-'a']++;
        }
        for(int i=0;i<ransomNote.length();i++){
        	if(map[ransomNote.charAt(i)-'a']>0){
        		map[ransomNote.charAt(i)-'a']--;
        	}else{
        		return false;
        	}
        }
        return true;
    }
    
    public static void main(String[] args) {
		Test19 test19 = new Test19();
		System.out.println(test19.canConstruct("aa", "ab"));
	}
}
