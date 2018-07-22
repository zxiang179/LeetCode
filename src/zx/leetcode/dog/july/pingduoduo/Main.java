package zx.leetcode.dog.july.pingduoduo;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	/**
	 * 第三题
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String inputStr = scanner.nextLine();
		String[] splits = inputStr.split("\\s+");
		int N = splits.length;
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.valueOf(splits[i]);
		}
		Arrays.sort(arr);
		// 车辆数
		int count = 0;
		int start = 0;
		int end = N - 1;
		while (start <= end) {
			if (arr[end] >= 300) {
				count++;
				end--;
			} else {
				int temp = arr[start] + arr[end];
				while (temp < 300 && start < end) {
					start++;
					temp += arr[start];
				}
				if (start <= end) {
					end--;
					count++;
				}
			}
		}
		System.out.println(count);
	}

}
