package zx.leetcode.chicken.july;
/**
 * 643. Maximum Average Subarray I
 * @author Carl_Hugo
 *
 */
public class Test22 {
	
	
	public double findMaxAverage(int[] nums, int k) {
		int sum=0;
		for(int i=0;i<k;i++){
			sum+=nums[i];
		}
		int max = sum;
		for(int i=k;i<nums.length;i++){
			sum+=nums[i]-nums[i-k];
			max = Math.max(sum, max);
		}
		return max/1.0/k;
	}
	
    /**
     * Given an array consisting of n integers, 
     * find the contiguous subarray of given length k that has the maximum average value. 
     * And you need to output the maximum average value.
     * @param nums
     * @param k
     * @return
     */
	public double findMaxAverage2(int[] nums, int k) {
       int[] add = new int[nums.length+1];
       add[1] = nums[0];
       double max = nums[0];
       for(int i=1;i<nums.length;i++){
    	   add[i+1]=nums[i]+add[i];
       }
       for(int i=k;i<add.length;i++){
    	   int temp = add[i]-add[i-k];
    	   if(temp>=max)max=temp;
       }
       return max/k;
    }
	
	public static void main(String[] args) {
		new Test22().findMaxAverage(new int[]{4,0,4,3,3}, 5);
	}
	

}
