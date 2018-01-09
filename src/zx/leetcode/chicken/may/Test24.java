package zx.leetcode.chicken.may;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * 347. Top K Frequent Elements
 * @author Carl_Hugo
 * @date 2017年5月20日
 */
public class Test24 {

	/**
	 * Given a non-empty array of integers, return the k most frequent elements.
     * For example,
     * Given [1,1,1,2,2,3] and k = 2, return [1,2].
	 * @param nums
	 * @param k
	 * @return
	 */
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        List<Integer>[] bucket = new List[nums.length+1];
        List<Integer> res = new ArrayList<Integer>();
    	for(int num:nums){
    		map.put(num, map.getOrDefault(num,0)+1);
        }
    	Set<Entry<Integer, Integer>> entry = map.entrySet();
    	for(Entry<Integer,Integer> es:entry){
    		int key = es.getKey();
    		int value = es.getValue();
    		if(bucket[value]==null){
    			bucket[value] = new ArrayList<Integer>();
    		}
    		bucket[value].add(key);
    	}
    	for(int i = bucket.length-1;i>=0&&res.size()<k;i--){
    		if(bucket[i]!=null){
    			res.addAll(bucket[i]);
    		}
    	}
    	return res;
    }
    
    public static void main(String[] args) {
		new Test24().topKFrequent(new int[]{1}, 1);
	}
	
}
