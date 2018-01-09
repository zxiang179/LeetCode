package zx.leetcode.chicken.may;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * 260. Single Number III
 * @author Carl_Hugo
 * @date 2017年5月17日
 */
public class Test20 {
	
	/**
	 * Given an array of numbers nums, 
	 * in which exactly two elements appear only once and all the other elements appear exactly twice. 
	 * Find the two elements that appear only once.
	 * @param nums
	 * @return
	 */
    public int[] singleNumber(int[] nums) {
       int[] result = new int[2];
       int k=0;
       Map<Integer,Integer> map = new HashMap<Integer,Integer>();
       for(int i:nums){
    	   if(!map.containsKey(i)){
    		   map.put(i, 1);
    	   }else{
    		   map.put(i, map.get(i)+1);
    	   }
       }
       Set<Entry<Integer,Integer>> entrySet = map.entrySet();
       for(Entry es:entrySet){
    	   int count=(Integer)es.getValue();
    	   if(count!=2){
    		   result[k++]=(Integer)es.getKey();
    	   }
       }
       return result;
    }

}
