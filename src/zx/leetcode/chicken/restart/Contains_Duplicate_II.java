package zx.leetcode.chicken.restart;

import java.util.HashMap;
import java.util.Map;

public class Contains_Duplicate_II {
	
	public boolean containsNearbyDuplicate(int[] nums,int k){
		if(nums==null||nums.length==0||k<0)return false;
		Map<Integer,Integer> map = new HashMap<Integer,Integer>();
		//flag 表示存在
		boolean flag = false;
		for(int i=0;i<nums.length;i++){
			if(!map.containsKey(nums[i])){
				map.put(nums[i], i);
			}else{
				int j = map.get(nums[i]);
				if(i-j<=k){
					flag = true;
					break;
				}else{
					map.put(nums[i], i);
				}
			}
		}
		return flag;
		
	}

}
