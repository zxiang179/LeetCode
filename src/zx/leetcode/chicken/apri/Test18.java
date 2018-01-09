package zx.leetcode.chicken.apri;

/**
 * 453. Minimum Moves to Equal Array Elements
 * @author Carl_Hugo
 */
public class Test18 {
	
	/**
	 * Input:
     * [1,2,3]
     * Output:
     * 3
     * Explanation:
     * Only three moves are needed (remember each move increments two elements):
     * [1,2,3]  =>  [2,3,3]  =>  [3,4,3]  =>  [4,4,4]
     * 每次将n-1个元素加1，直到数组中所有元素都相等
	 * @param nums
	 * @return
	 */
    public int minMoves(int[] nums) {
        int min = nums[0];
        int sum =0;
        for(int i=0;i<nums.length;i++){
        	if(min>nums[i]){
        		min=nums[i];
        	}
        	sum+=nums[i];
        }
        return sum-min*nums.length;
    }

}
