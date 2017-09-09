package zx.leetcode.Sep.jd;

public class Test1 {
	
	static int cnt =0;
	
	public static void main(String[] args) {
		fib(7);
		System.out.println(cnt);
	}
	
	static int fib(int n){
		cnt++;
		if(n==0)return 1;
		else if(n==1){
			return 1;
		}else{
			return fib(n-1)+fib(n-2);
		}
	}

}
