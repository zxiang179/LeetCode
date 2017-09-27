package zx.leetcode.Sep;

import java.util.HashMap;
import java.util.Map;
/**
 * 677. Map Sum Pairs
 * @author Carl_Hugo
 * 2017年9月27日 上午9:20:52
 */
public class Map_Sum_Pairs {

	Map<String,Integer> map;
	
	/** Initialize your data structure here. */
    public Map_Sum_Pairs() {
    	map = new HashMap<String,Integer>();
    }
    
    public void insert(String key, int val) {
    	map.put(key, val);
    }
    
    public int sum(String prefix) {
    	int sum = 0;
    	for(String str:map.keySet()){
    		if(str.startsWith(prefix)){
    			sum+=map.get(str);
    		}
    	}
        return sum;
    }
    
}
