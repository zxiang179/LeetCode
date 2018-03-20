package zx.leetcode.dog.mar;

import java.util.SortedSet;
import java.util.TreeSet;

public class Contains_Duplicate_III_220 {
	
	public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
		if(k<1||t<0||nums==null||nums.length<2){
			return false;
		}
		SortedSet<Long> set = new TreeSet<Long>();
		
		for(int j=0;j<nums.length;j++){
			SortedSet<Long> subSet = set.subSet((long)nums[j]-t, (long)nums[j]+t+1);
			if(!subSet.isEmpty()){
				return true;
			}
			//每次移动窗口，需要把数组前面的数字移除
			if(j>=k){
				set.remove((long)nums[j-k]);
			}
			set.add((long)nums[j]);
		}
        return false;
    }
	
	public static void main(String[] args) {
		new Contains_Duplicate_III_220().containsNearbyAlmostDuplicate(new int[]{-3,3}, 2, 4);
	}

}
