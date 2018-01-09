package zx.leetcode.chicken.restart;

public class Valid_Palindrome {
	
	public boolean isPalindrome(String s){
		char[] cArr = s.toCharArray();
		StringBuilder sb = new StringBuilder();
		
		//将字符串预处理并保存在sb中
		for(int i=0;i<cArr.length;i++){
			if(cArr[i]>='A'&&cArr[i]<='Z'||cArr[i]>='a'&&cArr[i]<='z'||cArr[i]>='0'&&cArr[i]<='9'){
				String tempStr = String.valueOf(cArr[i]).toLowerCase();
				sb.append(tempStr);
			}
		}
		String str = sb.toString();
		String reverseStr = sb.reverse().toString();
		if(reverseStr.equals(str)){
			return true;
		}else{
			return false;
		}
	}

}
