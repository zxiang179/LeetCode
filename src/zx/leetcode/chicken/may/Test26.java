package zx.leetcode.chicken.may;
/**
 * 384. Shuffle an Array
 * @author Carl_Hugo
 * @date 2017年5月22日
 */
public class Test26 {
	
	private int[] nums;
	
	public Test26(int[] nums){
		this.nums=nums;
	}
	
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return nums;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int[] rand = new int[nums.length];
        for(int i=0;i<nums.length;i++){
        	int r = (int)(Math.random()*(i+1));
        	rand[i] = rand[r];
        	rand[r] = nums[i];
        }
        return rand;
    }
    
    public static void main(String[] args) {
	}

}
