package zx.leetcode.may;
/**
 * 35. Search Insert Position
 * @author Carl_Hugo
 * @date 2017年5月8日
 */
public class Test16 {
	
	/**
	 * Given a sorted array and a target value, 
	 * return the index if the target is found. 
	 * If not, return the index where it would be if it were inserted in order.
	 * @param nums
	 * @param target
	 * @return
	 */
    public int searchInsert(int[] nums, int target) {
    	int i=0;
    	while(i<nums.length){
    		if(target>nums[i]){
    			i++;
    		}else{
    			break;
    		}
    	}
    	return i;
    }
    
    public static void main(String[] args) {
		System.out.println(new Test16().searchInsert(new int[]{1,3,5,6},0));
	}

}
