package zx.leetcode.dog.july.pingduoduo;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Main2 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String nextLine = scanner.nextLine();
		String[] firstSplit = nextLine.split("\\s");
		// 候选球星
		int N = Integer.valueOf(firstSplit[0]);
		// 选票数量
		int M = Integer.valueOf(firstSplit[1]);
		if(N==1){
			System.out.println(0);
		}else{
			String[] strArr = new String[N];
			// 候选球星票数数组
			String[] candArr = new String[N];
			for (int i = 0; i < M; i++) {
				strArr[i] = scanner.nextLine();
			}
			// 竖着遍历
			for (int j = 0; j < N; j++) {
				StringBuilder sb = new StringBuilder();
				for (int i = 0; i < M; i++) {
					sb.append(strArr[i].charAt(j));
				}

				candArr[j] = StringSortMethodOne(sb.toString());
			}
			
			Map<String,Integer> map = new HashMap<String,Integer>();
			for(int i=0;i<N;i++){
				map.put(candArr[i], i);
			}
			Arrays.sort(candArr);
			
			System.out.println((candArr[0].equals(candArr[1]))?-1:map.get(candArr[0]));	
		}
		
	}

	public static String StringSortMethodOne(String a) {
		char[] arr = a.toCharArray();
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] > arr[j]) {
					char temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}

		}
		String b = new String(arr);
		return b;
	}

}
