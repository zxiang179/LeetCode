package zx.leetcode.sort;

public class QuickSort {
	
	public int partition(int[] arr,int low,int high){
		int key = arr[low];
		while(low<high){
			while(arr[high]>=key&&low<high){
				high--;
			}
			arr[low] = arr[high];
			while(arr[low]<=key&&low<high){
				low++;
			}
			arr[high] = arr[low];
		}
		arr[high] = key;
		return high;
	}
	
	public void quickSort(int[] arr,int low,int high){
		if(low>=high)return;
		int index = partition(arr,low,high);
		quickSort(arr,low,index-1);
		quickSort(arr,index+1,high);
	}
	
	public static void main(String[] args) {
		int[] arr = {1,4,24,3,22,15,18};
		new QuickSort().quickSort(arr, 0, arr.length-1);
		for(int a:arr){
			System.out.print(a+" ");
		}
	}
	

}
