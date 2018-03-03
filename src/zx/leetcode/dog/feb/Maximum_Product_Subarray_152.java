package zx.leetcode.dog.feb;

public class Maximum_Product_Subarray_152 {

	/**
	 * 
	 * 此题局部最优并不能代表全局最优 乘法因为存在负数 所以需要维护一个最小数组 dp_min[i] =
	 * min(dp_min[i-1]*A[i],dp_max[i-1]*A[i],A[i]) dp_max[i] =
	 * max(dp_min[i-1]*A[i],dp_max[i-1]*A[i],A[i]) max(max,dp_max[i])
	 * 
	 * @param nums
	 * @return
	 */
	public int maxProduct(int[] nums) {
		int n = nums.length;
		int max=nums[0];
		int[] dp_min = new int[n];
		int[] dp_max = new int[n];
		dp_min[0]=dp_max[0]=nums[0];			
		for(int i=1;i<nums.length;i++){
			dp_min[i] = Math.min(
					nums[i],Math.min(dp_min[i-1]*nums[i], dp_max[i-1]*nums[i]));
			dp_max[i] = Math.max(
					nums[i],Math.max(dp_min[i-1]*nums[i], dp_max[i-1]*nums[i]));
			max = Math.max(dp_max[i], max);
		}
	
        return max;
    }

	public static void main(String[] args) {
		new Maximum_Product_Subarray_152()
				.maxProduct(new int[] { 2, 3, -2, 4 });
	}

}
