package zx.leetcode.restart;

public class Count_Primes {
	
	public static int countPrimes2(int n){
		//初始化后默认是false
		boolean[] isComposite = new boolean[n];
		int count = 0;
		for(int i=2;i<n;i++){
			if(!isComposite[i]){
				//当前数为素数
				count++;
				for(int j=2;i*j<n;j++){
					isComposite[i*j] = true;
				}
			}
		}
		return count;
	}
	
	public static int countPrimes(int n) {
		int[] a = new int[n+1];
		int count = 0;
		a[0] = 0;
		if(n!=0)a[1]=0;
		for(int i=2;i<n;i++){
			a[i] = 1;
		}
		
		for(int i=2;i*i<n;i++){
			if(a[i]==1){
				for(int j=i*2;j<=n;j=i+j){
					if(j%i==0){
						a[j]=0;
					}
				}
			}
		}
		
		for(int i=0;i<n;i++){
			if(a[i]==1){
				count++;
			}
		}
		return count;
	}

	public static void main(String[] args) {
		countPrimes2(1000);
	}
	
}
