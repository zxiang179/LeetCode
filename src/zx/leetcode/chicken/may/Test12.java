package zx.leetcode.chicken.may;
/**
 * 53. Maximum Subarray
 * @author Carl_Hugo
 * @date 2017年5月6日
 */
public class Test12 {

	int[] sum;
    /**
     * Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
     * For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
     * the contiguous subarray [4,-1,2,1] has the largest sum = 6.
     * @param nums
     * @return
     */
	public int maxSubArray(int[] nums) {
        return init(nums);
    }
	
	public int init(int[] nums){
		int max = nums[0];
		sum = new int[nums.length];
		sum[0] = nums[0];//sum[i] means max subarray ending with nums[i] 
		for(int i=1;i<nums.length;i++){
			sum[i] = nums[i]+(sum[i-1]>0?sum[i-1]:0);
			max = Math.max(sum[i], max);
		}
		return max;
	}
	
	public static void main(String[] args) {
		new Test12().maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4});
	}

}
