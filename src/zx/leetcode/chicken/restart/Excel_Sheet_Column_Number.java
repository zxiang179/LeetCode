package zx.leetcode.chicken.restart;

import org.junit.Test;

public class Excel_Sheet_Column_Number {
	
	 public int titleToNumber(String s) {
		 int result = 0;
		 char[] cArr = s.toCharArray();
		 int count = 0;
		 for(int i=cArr.length-1;i>=0;i--){
			 int temp = cArr[i]-'A'+1;
			 result += temp*Math.pow(26, count);
			 count++;
		 }
		 return result;
	 }
	 
	 @Test
	 public void test(){
		 System.out.println(titleToNumber("Z"));
	 }

}
