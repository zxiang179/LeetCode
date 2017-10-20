package zx.leetcode.restart;

import java.util.Arrays;

import org.junit.Test;

public class Plus_One {
	
	public int[] plusOne(int[] digits) {
		int carry = 0;
		int[] res = new int[digits.length+1];
		int temp = digits[digits.length-1]+1;
		for(int i=digits.length-1;i>=0;i--){
			if(i!=digits.length-1)temp = digits[i]+carry;
			if(temp>=10){
				res[i]=temp%10;
				carry = 1;
			}else{
				res[i]=temp;
				carry = 0;
			}
		}
		if(carry==1){
			res[0]=1;
			return res;
		}else{
			return Arrays.copyOfRange(res, 0, res.length-1);
		}
    }
	
    @Test
    public void test(){
    	int[] res = plusOne(new int[]{9,9,8});
    	for(int i:res){
    		System.out.print(i+" ");
    	}
    }
	
}
