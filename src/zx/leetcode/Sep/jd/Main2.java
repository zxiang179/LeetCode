package zx.leetcode.Sep.jd;

public class Main2 {
	
	private static int j =0;
	private static boolean test1(int k){
		j+=k;
		return true;
	}
	
	public static void test2(int i){
		boolean b;
		b=i<100|test1(3);
		b=i<010|test1(6);
	}
	
	public static void main(String[] args) {
		test2(2);
		System.out.println(j);
	}

}
