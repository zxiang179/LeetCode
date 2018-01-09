package zx.leetcode.chicken.Aug;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * 451. Sort Characters By Frequency
 * @author Carl_Hugo
 * @date 2017年8月28日
 */
public class Sort_Characters_By_Frequency {
	
	public String frequencySort(String s) {
		Map<Character,Integer> map = new HashMap<Character,Integer>();
	    List<Character> resList = new ArrayList<Character>();
	    String str = "";
	    for(int i=0;i<s.length();i++){
	    	map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0)+1);
	    }
	    List<Character>[] bucket = new List[s.length()+1];

	    for(char key : map.keySet()){
	    	int frequency = map.get(key);
	    	if(bucket[frequency]==null){
	    		bucket[frequency]=new ArrayList<>();
	    	}
	    	bucket[frequency].add(key);
	    }
	    
	    StringBuilder sb = new StringBuilder();
	    
	    for(int pos = bucket.length-1;pos>=0;pos--){
	    	if(bucket[pos]!=null){
	    		for(char c:bucket[pos]){
	    			for(int i=0;i<map.get(c);i++){
	    				sb.append(c);
	    			}
	    		}
	    	}
	    }
	    
	    return sb.toString();
	}
	
	public static void main(String[] args) {
		System.out.println(new Sort_Characters_By_Frequency().frequencySort("tree"));
	}

}
