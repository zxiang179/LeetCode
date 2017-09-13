package zx.leetcode.Sep.zhaoshangyinhang;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		String[] split = input.split("\\s");
		int count = 0;
		int min = Integer.valueOf(split[0]);
		int max = Integer.valueOf(split[1]);
		int n = Integer.valueOf(split[2]);
		if (max < min) {
			int temp = min;
			min = max;
			max = temp;
		}
		int minLCM = Lcm(min, max);
		
		for(int i=minLCM;i<=n;i++){
			if(i%min==0&&i%max==0){
				count++;
			}
		}
		System.out.println(count);
		
	}

	// 求最大公约数
	public static int Gcd(int min, int max) {
		// 利用递归，大的数除小的数，若余数不为0，则让较小得数（min）做被除数，余数（k）做除数，直到k=0，此时min为最大公约数
		// 运用递归调用将求余之后的值作为min * 将之前的min作为max直到求余值为0为止结束循环
		while (max % min != 0) {
			int k = max % min;
			max = min;
			min = k;
		}
		return min;
	}

	// 求最小公倍数
	public static int Lcm(int min, int max) {
		// 最小公倍数就是两个数相乘再除以最大公约数
		return min * max / Gcd(min, max);
	}

}
