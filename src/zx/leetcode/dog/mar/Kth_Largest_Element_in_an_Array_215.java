package zx.leetcode.dog.mar;

public class Kth_Largest_Element_in_an_Array_215 {
	
	public int findKthLargest(int[] nums, int k) {
		int len = nums.length-1;
		int index = partition(nums,0,len);
		while(index!=k-1){
			if(index<k-1){
				index = partition(nums,index+1,len);
			}else if(index>k-1){
				index = partition(nums,0,index-1);
			}	
		}
		return nums[index];
    }

	public int partition(int[] nums,int i,int j){
		int key = nums[i];
		while(i<j){
			while(i<j&&nums[j]<=key){
				j--;
			}
			nums[i] = nums[j];
			while(i<j&&nums[i]>=key){
				i++;
			}
			nums[j] = nums[i];
		}
		nums[i] = key;
		return i;
	}
	
	public static void main(String[] args) {
		System.out.println(new Kth_Largest_Element_in_an_Array_215().findKthLargest(new int[]{3,2,1,5,6,4}, 2));
	}
	
}
