package zx.leetcode.Sep;
/**
 * 162. Find Peak Element
 * @author Carl_Hugo
 * 2017年9月27日 上午8:54:23
 */
public class Find_Peak_Element {
	
    public int findPeakElement(int[] nums) {
    	int len = nums.length;
    	if(len==1)return 0;
    	if(len==2)return nums[0]>nums[1]?0:1;
    	int first = 0;
    	int mid = 1;
    	int last = 2;
    	if(nums[len-1]>nums[len-2]){
    		return len-1;
    	}
    	if(nums[0]>nums[1]){
    		return 0;
    	}
    	while(last<nums.length){
    		if(nums[first]<nums[mid]&&nums[mid]>nums[last]){
    			return mid;
    		}
    		if(nums[first]>nums[mid]&&nums[mid]<nums[last]){
    			return mid;
    		}
    		first++;
    		mid++;
    		last++;
    	}
        return -1;
    }

}
