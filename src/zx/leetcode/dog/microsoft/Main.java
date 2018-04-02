package zx.leetcode.dog.microsoft;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

	public List<Integer> returnList(int sizeOfList, int numOfOp,
			int[] inputList, int[][] listOfOp) {
		for (int i = 0; i < listOfOp.length; i++) {
			int opt = listOfOp[i][0];
			int x = listOfOp[i][1];
			int y = listOfOp[i][2];
			int v = listOfOp[i][3];
			switch (opt) {
			case 1:
				add(inputList, x - 1, y - 1, v);
				break;
			case 2:
				sub(inputList, x - 1, y - 1, v);
				break;
			case 3:
				init(inputList, x - 1, y - 1, v);
				break;
			case 4:
				findSumAndAddAll(inputList, x - 1, y - 1, v);
				break;
			}
		}
		List<Integer> resList = new ArrayList<Integer>();
		for(int i:inputList){
			resList.add(i);
		}
		return resList;
	}

	private static void findSumAndAddAll(int[] inputList, int x, int y, int v) {
		int sum = 0;
		for (int i = x; i <= y; i++) {
			sum += inputList[i];
		}
		for (int i = 0; i < inputList.length; i++) {
			inputList[i] += sum;
		}
	}

	private static void init(int[] inputList, int x, int y, int v) {
		for (int i = x; i <= y; i++) {
			inputList[i] = v;
		}
	}

	private static void sub(int[] inputList, int x, int y, int v) {
		for (int i = x; i <= y; i++) {
			inputList[i] -= v;
		}
	}

	private static void add(int[] inputList, int x, int y, int v) {
		for (int i = x; i <= y; i++) {
			inputList[i] += v;
		}
	}
	
	public static void main(String[] args) {
		new Main().returnList(6, 3, new int[]{-19,-16,-8,-10,-6,-20}, new int[][]{{1,1,5,20},{2,1,6,20},{1,6,6,20}});
		
		/*Scanner scanner = new Scanner(System.in);
		int sizeOfList = scanner.nextInt();
		int numsOfOp = scanner.nextInt();
		int[] inputList = new int[sizeOfList];
		for (int i = 0; i < sizeOfList; i++) {
			inputList[i] = scanner.nextInt();
		}
		int[][] listOfOp = new int[numsOfOp][4];
		for (int i = 0; i < listOfOp.length; i++) {
			for (int j = 0; j < listOfOp[0].length; j++) {
				listOfOp[i][j] = scanner.nextInt();
			}
		}

		for (int i = 0; i < listOfOp.length; i++) {
			int opt = listOfOp[i][0];
			int x = listOfOp[i][1];
			int y = listOfOp[i][2];
			int v = listOfOp[i][3];
			switch (opt) {
			case 1:
				add(inputList, x - 1, y - 1, v);
				break;
			case 2:
				sub(inputList, x - 1, y - 1, v);
				break;
			case 3:
				init(inputList, x - 1, y - 1, v);
				break;
			case 4:
				findSumAndAddAll(inputList, x - 1, y - 1, v);
				break;
			}
		}

		for (int i : inputList) {
			System.out.print(i);
		}*/
	}


}
