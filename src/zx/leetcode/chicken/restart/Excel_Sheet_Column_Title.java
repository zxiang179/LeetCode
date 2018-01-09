package zx.leetcode.chicken.restart;

import org.junit.Test;

public class Excel_Sheet_Column_Title {
	
	 public String convertToTitle(int n) {
		 StringBuilder sb = new StringBuilder();
		 int temp;
		 while(n>0){
			 temp = (n-1)%26;
			 sb.append((char)(temp+'A'));
			 n=(n-1)/26;
		 }
		 return sb.reverse().toString();
	 }
	 
	 @Test
	 public void test(){
		 System.out.println(convertToTitle(1));
		 System.out.println(convertToTitle(25));
		 System.out.println(convertToTitle(26));
		 System.out.println(convertToTitle(27));
		 System.out.println(convertToTitle(28));
		 System.out.println(convertToTitle(29));
	 }

}
