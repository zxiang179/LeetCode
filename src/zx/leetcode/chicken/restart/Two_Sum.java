package zx.leetcode.chicken.restart;

import java.util.HashMap;
import java.util.Map;

public class Two_Sum {
	
	public int[] twoSum(int[] nums, int target) {
		Map<Integer,Integer> map = new HashMap<Integer,Integer>();
		int[] res = new int[2];
		for(int i=0;i<nums.length;i++){
			if(!map.containsKey(target-nums[i])){
				map.put(nums[i], i);
			}else{
				res[0]=map.get(target-nums[i]);
				res[1]=i;
			}
		}
        return res;
    }

}
