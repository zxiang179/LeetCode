package zx.leetcode.chicken.restart;

public class Add_String {
	
	public String addStrings(String num1, String num2) {
		int len1 = num1.length();
		int len2 = num2.length();
		int resLen = len1>len2?len1:len2;
		int[] res = new int[resLen+1];
		
		int carry = 0;
		int k = resLen;
		int i= len1-1;
		int j= len2-1;
		while(i>=0||j>=0){
			int first = (i>=0?num1.charAt(i):'0')-'0';
			int second = (j>=0?num2.charAt(j):'0')-'0';
			int digitSum = first+second+carry;
			if(digitSum>=10){
				res[k--] = digitSum - 10;
				carry = 1;
			}else{
				res[k--] = digitSum;
				carry = 0;
			}
			i--;
			j--;
		}
		if(carry>0){
			res[0]=1;
		}
		
		StringBuilder sb = new StringBuilder();
		if(res[0]!=0)sb.append(res[0]);
		for(int l=1;l<resLen+1;l++){
			sb.append(res[l]);
		}
        return sb.toString();
    }

}
