package zx.leetcode.dog.jan;
/**
 * 
 * @author Carl_Hugo
 * 2018年1月15日 上午9:44:40
 */
public class Is_Subsequence {
	
	/**
	 * s = "abc", t = "ahbgdc"
	 * Return true.
	 * @param s
	 * @param t
	 * @return
	 */
	public boolean isSubsequence(String s, String t) {
        char[] sCharArray = s.toCharArray();
        char[] tCharArray = t.toCharArray();
        int i = 0;
        while(i<sCharArray.length){
        	for(int j=0;j<tCharArray.length;j++){
        		if(sCharArray[i]==tCharArray.length){
        			i++;
        			if(i==s.toCharArray().length-1){
        				return true;
        			}
        		}
        	}
        	i=0;	
        }
        return false;
    }

}
