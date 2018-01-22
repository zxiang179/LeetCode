package zx.leetcode.dog.jan;

import org.junit.Test;

/**
 * 
 * @author Carl_Hugo
 * 2018年1月19日 下午10:26:43
 */
public class Prime_Number_of_Set_Bits_in_Binary_Representation {
	
	
	public int countPrimeSetBits(int L, int R) {
		init();
		int length = R-L+1;
		int[] binaryInt = new int[length];
		int countBinary = 0;
		for(int i=L;i<=R;i++){
			binaryInt[i-L]=bitCount(i);
			if(primeList[binaryInt[i-L]]==true){
				countBinary++;
			}
		}
		return countBinary;
        
    }
	
	@Test
	public void test(){
		int a = 15;
		System.out.println(bitCount(a));
		init();
		
	}

	//默认初始值为false
	boolean[] primeList = new boolean[100];
	
	public void init(){
		for(int i=0;i<primeList.length;i++){
			primeList[i] = true;
		}
		primeList[0]=false;
		primeList[1]=false;
		for(int i=1;i*i<100;i++){
			if(primeList[i]==true){
				for(int j=2;i*j<100;j++){
					primeList[i*j]=false;
				}
			}
		}
		for(int i=0;i<primeList.length;i++){
			if(primeList[i]==true){
				System.out.print(i+" ");
			}
		}
	}
	
	public int bitCount(int n){
		int c = 0;
		while(n!=0){
			n=n&(n-1);
			++c;
		}
		return c;
	}

}
