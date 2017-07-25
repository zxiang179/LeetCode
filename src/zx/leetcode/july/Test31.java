package zx.leetcode.july;
/**
 * 459. Repeated Substring Pattern
 * @author Carl_Hugo
 * 2017年7月25日 下午1:47:34
 */
public class Test31 {
	
	/**
	 * 
	 * @param s
	 * @return
	 */
    public boolean repeatedSubstringPattern(String s) {
    	int l = s.length()/2;
    	for(int i=l;i>=1;i--){
    		if(s.length()%i==0){
    			int m = s.length()/i;
    			String str = s.substring(0, i);
        		StringBuilder sb = new StringBuilder();
        		for(int j=0;j<m;j++){
        			sb.append(str);
        		}
        		if(sb.toString().equals(s))return true;
    		}
    	}
    	return false;
    }

    public static void main(String[] args) {
		new Test31().repeatedSubstringPattern("ababab");
	}
}
