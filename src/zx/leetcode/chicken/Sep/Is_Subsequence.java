package zx.leetcode.chicken.Sep;
/**
 * 392. Is Subsequence
 * @author Carl_Hugo
 * 2017年9月8日 上午9:31:25
 */
public class Is_Subsequence {
	
    public boolean isSubsequence(String s, String t) {
    	if(s.equals(""))return true;
    	if(s.length()>t.length())return false;
    	boolean flag = true;
    	char firstS = s.charAt(0);
    	int firstIndex = t.indexOf(firstS);
    	if(firstIndex==-1)return false;
    	
    	if(s.length()>=2){
    		int prevTIndex = firstIndex;
    		int i = 1;
    		int j = prevTIndex;
    		for(i=1;i<s.length();){
        		char c = s.charAt(i);
        		while(j<t.length()){
        			char tempT = t.charAt(j);
        			if(tempT!=c){
        				j++;
        			}else{
        				i++;
        				break;
        			}
        		}
        		if(j==t.length()&&i<s.length())return false;
        	}	
    		return i<s.length()?false:true;
    	}
    	
        return flag;
    }
    
    public static void main(String[] args) {
		System.out.println(new Is_Subsequence().isSubsequence("axc","ahbgdc"));
	}

}
