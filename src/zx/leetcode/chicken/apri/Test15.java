package zx.leetcode.chicken.apri;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

/**
 * 506. Relative Ranks
 * @author Carl_Hugo
 */
public class Test15 {

	/**
	 * Input: [5, 4, 3, 2, 1]
     * Output: ["Gold Medal", "Silver Medal", "Bronze Medal", "4", "5"]
	 * @param nums
	 * @return
	 */
     public String[] findRelativeRanks(int[] nums) {
        String[] res = new String[nums.length];
		Map<Integer,Integer> treeMap = new TreeMap<Integer,Integer>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2-o1;
			}
		});
		
        for(int i=0;i<nums.length;i++){
        	treeMap.put(nums[i], i);
        }
       
        int rank=1;
        for(Map.Entry<Integer, Integer> m:treeMap.entrySet()){
//        	System.out.println(m.getKey()+":"+m.getValue());
        	
        	switch(rank){
	        	case 1:res[m.getValue()]="Gold Medal";break;
	        	case 2:res[m.getValue()]="Silver Medal";break;
	        	case 3:res[m.getValue()]="Bronze Medal";break;
	        	default:res[m.getValue()]=Integer.toString(rank);break;
        	}
        	
        	rank++;
        }
        return res;
    }
	
}
