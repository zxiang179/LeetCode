package zx.leetcode.apri;

import org.junit.Test;

/**
 * 476. Number Complement
 * @author Carl_Hugo
 * for 10010 its complement number is 01101 ,so we only need to get the min number large or equal to num,
 * then do substraction
 */
public class Test2 {
	
	 public int findComplement(int num) {
		 int i=0;
		 int j=0;
		 while(i<num){
			 i+=Math.pow(2, j);
			 j++;
		 }
		 return i-num;
	 }
	 
	 @Test
	 public void test(){
		 System.out.println(findComplement(5));
	 }

}
