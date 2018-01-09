package zx.leetcode.chicken.apri;

import java.util.ArrayList;
import java.util.List;

/**
 * 507. Perfect Number
 * @author Carl_Hugo
 *
 */
public class Test23 {

	/**
	 * We define the Perfect Number is a positive integer that is equal to the sum of all its positive divisors except itself.
	 * @param num
	 * @return
	 */
	public boolean checkPerfectNumber2(int num) {
        if(num==1)return false;
        
        int sum=0;
        for(int i=2;i<Math.sqrt(num);i++){
        	if(num%i==0){
        		sum+=i;
        		if(i!=num/i)sum+=num/i;
        	}
        }
        sum++;
        return sum==num?true:false;
    }
	
    public boolean checkPerfectNumber(int num) {
        int temp=num;
        int sum=0;
        List<Integer> list = new ArrayList<Integer>();
        for(int i=1;i<=num/2;i++){
        	if(temp%i==0){
        		list.add(i);
        		sum+=i;
        	}
        }
        System.out.println();
        return sum==num?true:false;
    }
    
    public static void main(String[] args) {
		Test23 test23 = new Test23();
		System.out.println(test23.checkPerfectNumber2(28));
	}
	
}
