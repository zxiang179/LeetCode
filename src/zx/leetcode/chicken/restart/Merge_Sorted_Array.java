package zx.leetcode.chicken.restart;

public class Merge_Sorted_Array {
	
	public static void merge(int[] nums1, int m, int[] nums2, int n) {
		int i=0;
		int j=0;
		int k=0;
		int[] res = new int[m+n];
		while(i<m&&j<n){
			if(nums1[i]<=nums2[j]){
				res[k++]=nums1[i++];
			}else{
				res[k++]=nums2[j++];
			}
		}
		while(i<m)res[k++]=nums1[i++];
		while(j<n)res[k++]=nums2[j++];
		for(int l=0;l<m+n;l++){
			nums1[l]=res[l];
		}
	}
	
	public static void merge2(int[] nums1, int m, int[] nums2, int n) {
		int i=m-1;
		int j=n-1;
		int k=m+n-1;
		while(i>=0&&j>=0){
			if(nums1[i]>=nums2[j]){
				nums1[k--]=nums1[i--];
			}else{
				nums1[k--]=nums2[j--];
			}
		}
		while(i>=0)nums1[k--]=nums1[i--];
		while(j>=0)nums1[k--]=nums2[j--];
	}
	
	public static void main(String[] args) {
		merge(new int[]{1,3,22,33,34,42,51},7,new int[]{1,4,11,42,46,73},6);
	}

}
