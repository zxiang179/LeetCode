package zx.leetcode.dog.apri;

public class Single_Number_136 {
	
	public int singleNumber(int[] nums) {
		int s = nums[0];
		for(int i=1;i<nums.length;i++){
			s = s^nums[i];
		}
		return s;
	}
	
	public static void main(String[] args) {
		new Single_Number_136().singleNumber(new int[]{1,1,2,2,3,4,4,5,5,6,6});
	}

}
