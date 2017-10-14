package zx.leetcode.restart;

import java.util.HashMap;
import java.util.Map;

public class Isomorphic_Strings {
	
	public boolean isIsomorphic(String s, String t) {
        return doCheck(s,t)&&doCheck(t,s);
    }
	
	public boolean doCheck(String s,String t){
		Map<Character,Character> map = new HashMap<Character,Character>();
		if(s.length()!=t.length())return false;
		for(int i=0;i<s.length();i++){
			char sChar = s.charAt(i);
			char tChar = t.charAt(i);
			if(!map.containsKey(sChar)){
				map.put(sChar, tChar);
			}else{
				char cCompare = map.get(sChar);
				if(cCompare!=tChar){
					return false;
				}
			}
		}
		return true;
	}

}
