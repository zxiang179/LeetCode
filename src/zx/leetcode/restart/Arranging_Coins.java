package zx.leetcode.restart;

public class Arranging_Coins {
	
	public int arrangeCoins(int n) {
		long nLong = (long)n;
		long s = 0;
		long e = n;
		long mid = 0;
		while(s<=e){
			mid = s+(e-s)/2;
			if(mid*(mid+1)<=2*nLong){
				s = mid+1;
			}else{
				e = mid-1;
			}
		}
        return (int)s-1;
    }

}
