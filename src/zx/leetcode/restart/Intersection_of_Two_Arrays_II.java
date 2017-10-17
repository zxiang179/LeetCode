package zx.leetcode.restart;

import java.util.Arrays;

public class Intersection_of_Two_Arrays_II {
	
	public int[] intersect(int[] nums1, int[] nums2) {
		Arrays.sort(nums1);
		Arrays.sort(nums2);
		int len1 = nums1.length;
		int len2 = nums2.length;
		int[] res = new int[len1>len2?len1:len2];
		int i = 0; 
		int j = 0;
		int count = 0;
		while(i<len1&&j<len2){
			if(nums1[i]==nums2[j]){
				res[count++] = nums1[i];
				i++;
				j++;
			}else if(nums1[i]<nums2[j]){
				i++;
			}else{
				j++;
			}
		}
		return Arrays.copyOf(res, count);
	}
}
