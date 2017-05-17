package zx.leetcode.may;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * 137. Single Number II
 * @author Carl_Hugo
 * @date 2017年5月17日
 */
public class Test19 {
    
	/**
	 * Given an array of integers, 
	 * every element appears three times except for one,
	 * which appears exactly once. Find that single one.
	 * @param nums
	 * @return
	 */
	public int singleNumber(int[] nums) {
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        int result=0;
        for(int i:nums){
        	if(!map.containsKey(i)){
        		map.put(i, 1);
        	}else{
        		map.put(i, map.get(i)+1);
        	}
        }
        Set<Entry<Integer,Integer>> entrySet = map.entrySet();
        for(Entry es:entrySet){
        	int count = (Integer)es.getValue();
        	if(count!=3){
        		result = (Integer)es.getKey();
        		break;
        	}
        }
        return result;
    }
	
	public static void main(String[] args) {
		new Test19().singleNumber(new int[]{2,2,3,2});
	}
}
