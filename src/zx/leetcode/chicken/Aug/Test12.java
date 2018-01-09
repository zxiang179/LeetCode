package zx.leetcode.chicken.Aug;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * 532. K-diff Pairs in an Array
 * @author Carl_Hugo
 * @date 2017年8月19日
 */
public class Test12 {
	
    public int findPairs(int[] nums, int k) {
    	int count = 0;
    	if(k!=0){
    		Set set = new HashSet();
        	//去重
        	for(int i=0;i<nums.length;i++){
        		set.add(nums[i]);
        	}
        	int[] newArr = new int[set.size()];
        	Iterator setIterator = set.iterator();
        	int countI=0;
        	while(setIterator.hasNext()){
        		newArr[countI++]=(int) setIterator.next();
        	}
        	
        	Arrays.sort(newArr);
        	for(int i=0;i<newArr.length;i++){
        		for(int j=i+1;j<newArr.length;j++){
        			if(Math.abs(newArr[i]-newArr[j])==k)count++;
        		}
        	}	
    	}else{
    		Map<Integer,Integer> map = new HashMap<Integer,Integer>();
    		for(int i=0;i<nums.length;i++){
    			if(map.containsKey(nums[i])){
    				int times = map.get(nums[i]);
    				map.put(nums[i], times+1);
    			}else{
    				map.put(nums[i], 1);
    			}
    		}
    		Set<Entry<Integer, Integer>> es = map.entrySet();
    		Iterator<Entry<Integer, Integer>> esIterator = es.iterator();
    		while(esIterator.hasNext()){
    			Entry<Integer, Integer> entry = esIterator.next();
    			int value = entry.getValue();
    			if(value>=2)count++;
    		}
    	}
    	
        return count;
    }
    
    public static void main(String[] args) {
		int[] arr = {3,1,4,1,5};
		System.out.println(new Test12().findPairs(arr, 2));
	}

}
