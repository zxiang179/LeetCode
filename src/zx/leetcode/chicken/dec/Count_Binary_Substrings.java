package zx.leetcode.chicken.dec;

import org.junit.Test;

/**
 * 
 * @author Carl_Hugo
 * 2017年12月5日 上午10:29:54
 */
public class Count_Binary_Substrings {
	
	public int countBinarySubstrings(String s) {
		int prevRunLength = 0;
		int curRunLength = 1;
		int res = 0;
		for(int i=1;i<s.length();i++){
			if(s.charAt(i)==s.charAt(i-1)){
				curRunLength++;	
			}else{
				prevRunLength = curRunLength;
				curRunLength = 1;
			}
			if(prevRunLength>=curRunLength)res++;
		}
        return res;
    }
	
	@Test
	public void test(){
		//10101
		int res = new Count_Binary_Substrings().countBinarySubstrings("10101");
		System.out.println(res);
	}

}
