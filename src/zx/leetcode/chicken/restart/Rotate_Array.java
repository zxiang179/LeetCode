package zx.leetcode.chicken.restart;

public class Rotate_Array {
	
	public void rotate(int[] nums,int k){
		int len = nums.length;
		k=k%len;
		reverse(nums,0,len-1);
		reverse(nums,0,k-1);
		reverse(nums,k,len-1);
	}
	
	public static void reverse(int[] nums,int start,int end){
		int temp;
		for(int i=start,j=end;i<=j;i++,j--){
			temp = nums[i];
			nums[i] = nums[j];
			nums[j] = temp;
		}
	}

}
