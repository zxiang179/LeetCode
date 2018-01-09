package zx.leetcode.chicken.Aug;
/**
 * 647. Palindromic Substrings
 * @author Carl_Hugo
 * 2017年8月21日 下午7:18:52
 */
public class Palindromic_Substrings {
	
	int count = 0;
	
	/**
	 * 计算字符串中子串中回文字符串的个数
	 * @param s
	 * @return
	 */
    public int countSubstrings(String s) {
    	if(s==null||s.length()==0)return 0;
    	for(int i=0;i<s.length();i++){
    		//寻找奇数长度的回文子串
    		extendPalindromic(s,i,i);
    		//寻找偶数长度的回文子串
    		extendPalindromic(s,i,i+1);
    	}
    	return count;
    }
    
    public void extendPalindromic(String s,int left,int right){
    	while(left>=0&&right<s.length()&&s.charAt(left)==s.charAt(right)){
    		count++;
    		left--;
    		right++;
    	}
    }
    
    public static void main(String[] args) {
		System.out.println(new Palindromic_Substrings().countSubstrings("aaa"));
	}

}
