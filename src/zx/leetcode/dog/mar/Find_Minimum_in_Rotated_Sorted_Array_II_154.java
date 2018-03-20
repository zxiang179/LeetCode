package zx.leetcode.dog.mar;

public class Find_Minimum_in_Rotated_Sorted_Array_II_154 {
	
	public int findMin(int[] nums) {
		if(nums.length==1){
			return nums[0];
		}
		int low = 0;
		int high = nums.length-1;
		int mid = low;
		while(nums[low]>=nums[high]){
			if(high-low==1){
				mid = high;
				break;
			}
			mid = (low+high)/2;
			if(nums[low]==nums[high]&&nums[low]==nums[mid]){
				return minNum(nums,low,high);
			}
			if(nums[low]<=nums[mid]){
				low = mid;
			}else if(nums[low]>=nums[mid]){
				high = mid;
			}
		}
        return nums[mid];
    }

	private int minNum(int[] nums,int low,int high) {
		int min = nums[low];
		for(int i = low+1;i<=high;i++){
			if(nums[i]<min){
				min = nums[i];
			}
		}
		return min;
	}
	
	public static void main(String[] args) {
		System.out.println(new Find_Minimum_in_Rotated_Sorted_Array_II_154().findMin(new int[]{3,1,1,1,1}));
	}

}
