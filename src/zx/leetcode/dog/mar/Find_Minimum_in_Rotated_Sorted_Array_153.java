package zx.leetcode.dog.mar;

public class Find_Minimum_in_Rotated_Sorted_Array_153 {

	/**
	 * (i.e., 0 1 2 4 5 6 7 might become 6 7 0 1 2 4 5). 查找中间元素的大小
	 * 如果中间元素大于nums[low] 则在mid+1~high中继续查找 如果中间元素小于nums[low] 则在low~mid-1中继续查找
	 * 
	 * @param nums
	 * @return
	 */
	public int findMin(int[] nums) {
		if(nums.length==1){
			return nums[0];
		}
		int low = 0;
		int high = nums.length - 1;
		int mid = low;
		while (nums[low] >= nums[high]) {
			if(high-low==1){
				mid = high;
				break;
			}
			mid = (low + high) / 2;
			if (nums[mid] < nums[low]) {
				high = mid;
			} else if (nums[mid] > nums[low]) {
				low = mid;
			}
		}
		return nums[mid];
	}

	public static void main(String[] args) {
		System.out.println(new Find_Minimum_in_Rotated_Sorted_Array_153()
				.findMin(new int[] { 1,2 }));
	}

}
