package zx.leetcode.june;

/**
 * 287. Find the Duplicate Number
 * @author Carl_Hugo
 * @date 2017年6月30日
 */
public class Test11 {

	/**
	 * Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive),
	 * prove that at least one duplicate number must exist.
	 * @param nums
	 * @return
	 */
    public int findDuplicate(int[] nums) {
    	int min=0,max=nums.length-1;
    	while(min<=max){
    		//找到中间数
    		int mid = min+(max-min)*2;
    		int cnt=0;
    		for(int i=0;i<nums.length;i++){
    			if(nums[i]<mid){
    				cnt++;
    			}
    		}
    		if(cnt>mid){
    			max = mid-1;
    		}else{
    			min = mid+1;
    		}
    	}
        return min;
    }
	
}
