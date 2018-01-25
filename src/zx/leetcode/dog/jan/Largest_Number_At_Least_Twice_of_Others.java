package zx.leetcode.dog.jan;

public class Largest_Number_At_Least_Twice_of_Others {

	public int dominantIndex(int[] nums) {
		int max = Integer.MIN_VALUE;
		boolean flag = true;
		int index = -1;
		for(int i=0;i<nums.length;i++){
			if(nums[i]>max){
				max = nums[i];
				index = i;
			}
		}
		for(int v:nums){
			if(v!=0&&v!=max){
				if(v*2>max){
					flag = false;
					break;
				}
			}
		}
        return flag==true?index:-1;
    }
	

}
