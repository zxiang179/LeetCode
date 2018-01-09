package zx.leetcode.chicken.restart;

public class Single_Number {

	public static int singleNumber(int[] A,int n){
		int result = 0;
		for(int i=0;i<n;i++){
			result^=A[i];
		}
		return result;
	}
	
	public static void main(String[] args) {
		singleNumber(new int[]{1,2,4,3,4,3,2},7);
	}
	
}
