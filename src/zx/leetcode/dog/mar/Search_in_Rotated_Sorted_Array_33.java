package zx.leetcode.dog.mar;

public class Search_in_Rotated_Sorted_Array_33 {
	
	/**
	 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
	 * @param nums
	 * @param target
	 * @return
	 */
	public int search(int[] nums, int target) {
		if(nums==null||nums.length==0){
			return -1;
		}
		int low = 0;
		int high = nums.length-1;
		while(low<=high){
			int mid = (low+high)/2;
			if(nums[mid]==target){
				return mid;
			}else if(nums[mid]<nums[high]){
				//数组右半边有序
				if(nums[mid]<target&&nums[high]>=target){
					low = mid+1;
				}else{
					high = mid-1;
				}
			}else{
				//数组左半边有序
				if(nums[low]<=target&&nums[mid]>target){
					high = mid-1;
				}else{
					low = mid + 1;
				}
			}
		}
		return -1;
    }
	
	public static void main(String[] args) {
		System.out.println(new Search_in_Rotated_Sorted_Array_33().search(new int[]{4,5,6,7,0,1,2}, 2));
	}

}
