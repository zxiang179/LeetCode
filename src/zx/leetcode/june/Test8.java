package zx.leetcode.june;

import java.util.HashMap;
import java.util.Map;

/**
 * 594. Longest Harmonious Subsequence
 * @author Carl_Hugo
 * @date 2017年6月29日
 */
public class Test8 {
	
    public int findLHS(int[] nums) {
    	Map<Integer,Integer> map = new HashMap<Integer,Integer>();
    	for(int i:nums){
    		map.put(i, map.getOrDefault(i, 0)+1);
    	}
    	int result=0;
    	for(int i:map.keySet()){
    		if(map.containsKey(i+1)){
    			result=Math.max(result, map.get(i)+map.get(i+1));
    		}
    	}
        return result;
    }
    
    public static void main(String[] args) {
		int[] test = {1,3,2,2,5,2,3,7};
		System.out.println(new Test8().findLHS(test));
	}

}
