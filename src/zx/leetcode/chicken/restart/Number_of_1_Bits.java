package zx.leetcode.chicken.restart;

public class Number_of_1_Bits {
	
	public static int hammingWeight(int n) {
		int count = 0;
		while(n!=0){
			count++;
			n=n&(n-1);
		}
		return count;
	}
	
	public static void main(String[] args) {
		System.out.println(hammingWeight(8));
	}

}
