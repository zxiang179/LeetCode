package zx.leetcode.dog.mar;

public class Ugly_Number_II_264 {
	
	public int nthUglyNumber(int n) {
		if(n==0)return 0;
		int[] uglyNum = new int[n];
		uglyNum[0] = 1;
		int factor2 = 2;
		int factor3 = 3;
		int factor5 = 5;
		int index2 = 0;
		int index3 = 0;
		int index5 = 0;
		for(int i=1;i<n;i++){
			int min = Math.min(factor2, Math.min(factor3, factor5));
			uglyNum[i] = min;
			if(min==factor2){
				factor2 = 2*uglyNum[++index2];
			}
			if(min==factor3){
				factor3 = 3*uglyNum[++index3];
			}
			if(min==factor5){
				factor5 = 5*uglyNum[++index5];
			}
		}
        return uglyNum[n-1];
    }
	
	public static void main(String[] args) {
		System.out.println(new Ugly_Number_II_264().nthUglyNumber(10));
	}

}
