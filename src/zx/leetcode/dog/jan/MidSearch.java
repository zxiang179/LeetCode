package zx.leetcode.dog.jan;

import java.util.Arrays;

public class MidSearch {
	
	public static void main(String[] args) {
		int[] arr = new int[]{1,3,43,6,34,62,55,23,2,12,22,121,31};
		Arrays.sort(arr);
		for(int i:arr){
			System.out.print(i+" ");			
		}
		System.out.println();
		System.out.println(midSearch(0,arr.length-1,arr,121));
	}
	
	private static int midSearch(int start,int end,int[] arr,int key){
		while(start<=end){
			int mid = start + (end-start)/2;
			if(arr[mid]>key){
				return midSearch(start,mid-1,arr,key);
			}else if(arr[mid]<key){
				return midSearch(mid+1,end,arr,key);
			}else{
				return mid;
			}
		}
		return -1;
	}
	
	

}
