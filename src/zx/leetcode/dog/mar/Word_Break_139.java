package zx.leetcode.dog.mar;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;


public class Word_Break_139 {
	
	/**
	 * dp[i] 表示字符串0~i-1能够被字典中的单词分割
	 * 
	 * 状态转移方程
	 * dp[i] = dp[j]&(string[j-1,i] in wordDict) (0<j<i)
	 * 
	 * 边界
	 * dp[0] = false;
	 * dp[i] = true  string[0~i] in wordDict
	 * @param s
	 * @param wordDict
	 * @return
	 */
	public boolean wordBreak(String s, List<String> wordDict) {
		if(wordDict==null||wordDict.size()==0||s==null||s.length()==0)return false;
		int n = s.length();
		boolean[] dp = new boolean[n+1];
		
		for(int i=0;i<n;i++){
			if(wordDict.contains(s.substring(0, i+1)))dp[i+1]=true;
			for(int j=0;j<=i;j++){
				String subStr = s.substring(j, i+1);
				dp[i+1] = dp[i+1]||(dp[j]&&wordDict.contains(subStr));
			}
		}
        return dp[n];
    }
	
	public static void main(String[] args) {
		List<String> wordDict = Arrays.asList(new String[]{"a"});
		String s = "a";
		System.out.println(new Word_Break_139().wordBreak(s, wordDict));
		
	}
	
	@org.junit.Test
    public void test() throws ParseException{
    	String tempLeaveDate = "2018-02-05T08:56:35.735Z";
    	String xq = "4";
    	String date = tempLeaveDate.substring(0, 10);
    	int nextMonths = 4*Integer.valueOf(xq);//默认一学期4个月
    	int currentMonth = Integer.valueOf(tempLeaveDate.substring(5,7));
    	System.out.println(currentMonth);
    	
    	int addedMonth = nextMonths + currentMonth;
    	int addedYear = 0;
    	while(addedMonth>=13){
    		addedMonth -= 12;
    		addedYear++;
    	}
    	int currentYear = Integer.valueOf(tempLeaveDate.substring(0,4));
    	int year = currentYear + addedYear;
    	int month = addedMonth;
    	System.out.println(String.valueOf(year)+"-"+String.valueOf(month)+"-"+tempLeaveDate.substring(8,10));
    	
    	
    }

}
