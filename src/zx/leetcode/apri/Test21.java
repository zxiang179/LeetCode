package zx.leetcode.apri;

/**
 * 541. Reverse String II
 * @author Carl_Hugo
 */
public class Test21 {
	
	/**
	 * 给一个字符串和一个整数k
	 * 当字符串长度小于k 将字符串整体逆序
	 * 当字符串长度大于k 小于2k时，将前k个字符串逆序，后面的字符串保持原样
	 * @param s
	 * @param k
	 * @return
	 */
    public String reverseStr(String s, int k) {
    	char[] charArray = s.toCharArray();
    	char temp;
    	for(int i=0;i<s.length();i=i+2*k){
    		int len= Math.min(k, s.length()-i);
    		int l=len+i-1;
    		for(int j=i;j<l;j++,l--){
    			temp=charArray[j];
    			charArray[j]=charArray[l];
    			charArray[l]=temp;
    		}
    	}
        return String.valueOf(charArray);
        
    }
    
    public static void main(String[] args) {
    	Test21 test21 = new Test21();
    	System.out.println("abcdefg");
		System.out.println(test21.reverseStr("abcdefg",2));
	}
    

}
