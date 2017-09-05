package zx.leetcode.Sep.chubao;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String NStr = "";
		while ((NStr = scanner.nextLine()) != null) {
			if(NStr.equals(""))break;
			int N = Integer.valueOf(NStr);
			String[] strArr = new String[N];
			for (int i = 0; i < N; i++) {
				strArr[i] = scanner.nextLine();
			}
			String MStr = scanner.nextLine();
			int M = Integer.valueOf(MStr);
			String[] subStr = new String[M];
			int[] res = new int[M];
			for (int i = 0; i < M; i++) {
				subStr[i] = scanner.nextLine();
			}

			for (int i = 0; i < M; i++) {
				int count = 0;
				for (int j = 0; j < N; j++) {
					if (strArr[j].contains(subStr[i])) {
						count++;
					}
				}
				res[i] = count;
			}
			for (int i = 0; i < M; i++) {
				System.out.println(res[i]);
			}
		}
	}

}
