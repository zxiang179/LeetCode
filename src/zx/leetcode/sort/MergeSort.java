package zx.leetcode.sort;

public class MergeSort {
	
	public int[] mergeSort(int[] arr,int low,int high){
		int mid = (low+high)/2;
		if(low<high){
			mergeSort(arr,low,mid);
			mergeSort(arr,mid+1,high);
			//将左右两边合并
			merge(arr,low,mid,high);
		}
		return arr;
	}
	
	public static void merge(int[] arr,int low,int mid,int high){
		int[] temp = new int[high-low+1];
		int i = low;
		int j = mid+1;
		int k = 0;
		while(i<=mid&&j<=high){
			if(arr[i]<=arr[j]){
				temp[k++] = arr[i++]; 
			}else{
				temp[k++] = arr[j++]; 
			}
		}
		while(i<=mid){
			temp[k++] = arr[i++];
		}
		while(j<=high){
			temp[k++] = arr[j++];
		}
		for(int x=0;x<temp.length;x++){
			arr[x+low] = temp[x];
		}
	}
	
	public static void main(String[] args) {
		int[] arr = {1,4,24,3,22,15,18};
		new QuickSort().quickSort(arr, 0, arr.length-1);
		for(int a:arr){
			System.out.print(a+" ");
		}
	}
	

}
