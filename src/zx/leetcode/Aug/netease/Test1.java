package zx.leetcode.Aug.netease;

import java.util.Arrays;
import java.util.Scanner;

public class Test1 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		//获取第一行数据
		int count = scanner.nextInt();
		//将第二行数据存放到数组中
		int[] arr = new int[count];
		for(int i=0;i<arr.length;i++){
			arr[i]=scanner.nextInt();
		}
		if(count==2)System.out.println("Possible");
		Arrays.sort(arr);
		int d = arr[1] - arr[0];
		int i;
		for(i=1;i<count-1;i++){
			int d1 = arr[i+1] - arr[i];
			if(d!=d1){
				System.out.println("Impossible");
				break;
			}
		}
		if(i==count-1){
			System.out.println("Possible");
		}
	}
	
	
}
