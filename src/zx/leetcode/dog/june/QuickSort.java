package zx.leetcode.dog.june;

public class QuickSort {

	public int partition(int[] arr, int left, int right) {
		int temp = arr[left];
		while (left < right) {
			while (left < right && temp <=arr[right])
				right--;
			arr[left] = arr[right];
			while (left < right && temp >=arr[left])
				left++;
			arr[right] = arr[left];
		}
		arr[left] = temp;
		return left;
	}

	public void sort(int[] arr,int left,int right) {
		if(left>=right) {
			return;
		}
		int index = partition(arr,left,right);
		sort(arr,left,index-1);
		sort(arr,index+1,right);
		
	}

	public static void main(String[] args) {
		int[] arr = {3,2,1,4,4,8,7,5};
		new QuickSort().sort(arr,0,arr.length-1);
		for (int i : arr) {
			System.out.print(i);
		}

	}

}
