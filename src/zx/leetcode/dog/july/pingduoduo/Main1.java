package zx.leetcode.dog.july.pingduoduo;

import java.util.Scanner;

public class Main1 {
	/**
	 * A B C D
		N <= 4  Nth name
		N >4 
		
		A B C D 'A A B B C C D D' A A A A B B B B C C C C D D D D'
		
		4 + 8 + 16 + 32 +2^(n-1)
		
		= 2^(n) - 4 > N  (n=7)
		
		(N - (2^(n-1) - 4))/4
	 * @param args
	 */
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();

		int temp = 4;
		while (true) {
			if (N - temp <= 0) {
				break;
			}
			N -= temp;
			temp *= 2;
		}
		if (N != 0) {
			int num = temp / 4;

			if (N % num == 0)
				N = N / num - 1;
			else
				N = N / num;
			if (N == 0)
				System.out.println("Alice");
			if (N == 1)
				System.out.println("Bob");
			if (N == 2)
				System.out.println("Cathy");
			if (N == 3)
				System.out.println("Dave");
		} else {
			System.out.println("Dave");
		}
	}

}
