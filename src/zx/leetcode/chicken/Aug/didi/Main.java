package zx.leetcode.chicken.Aug.didi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		List<Integer> list = new ArrayList<Integer>();
		Scanner scanner = new Scanner(System.in);
		String arrStr = scanner.nextLine();
		String[] arr = arrStr.split("\\s");
		int[] arrInt = new int[arr.length];
		for(int i=0;i<arr.length;i++){
			arrInt[i]=Integer.valueOf(arr[i]);
		}
		System.out.println(func(arrInt));
	}
	
	public static int func(int[] nums){
		int max = nums[0];
		int[] sum = new int[nums.length];
		sum[0] = nums[0];//sum[i] means max subarray ending with nums[i] 
		for(int i=1;i<nums.length;i++){
			sum[i] = nums[i]+(sum[i-1]>0?sum[i-1]:0);
			max = Math.max(sum[i], max);
		}
		return max;
	}

}
