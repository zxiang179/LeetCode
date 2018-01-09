package zx.leetcode.chicken.Aug;
/**
 * 38. Count and Say
 * @author Carl_Hugo
 * @date 2017年8月2日
 */
public class Test1 {
	
	
	public String countAndSay(int n) {
		StringBuilder curr = new StringBuilder("1");
		StringBuilder prev;
		int count;
		char say;
		for(int i=1;i<n;i++){
			prev=curr;
			curr = new StringBuilder();
			count = 1;
			say = prev.charAt(0);
			for(int j=1,len=prev.length();j<len;j++){
				if(prev.charAt(j)!=say){
					curr.append(count).append(say);
 	        		count=1;
 	        		say=prev.charAt(j);
				}
				else count++;
			}
			curr.append(count).append(say);
		}
		return curr.toString();
	}
	
	/**
	 * 1 is read off as "one 1" or 11.
     * 11 is read off as "two 1s" or 21.
     * 21 is read off as "one 2, then one 1" or 1211
     * 1.     1
     * 2.     11
     * 3.     21
     * 4.     1211
     * 5.     111221
	 * @param n
	 * @return
	 */
    public String countAndSay2(int n) {
    	String[] callWay = new String[n];
    	callWay[0]="1";
    	for(int i=1;i<n;i++){
    		String preStr = callWay[i-1];
    		int count = 0;
    		StringBuilder sb = new StringBuilder();
    		for(int j=0;j<preStr.length();j++){
    			char c = preStr.charAt(j);
    			if(j-1<0||preStr.charAt(j-1)!=preStr.charAt(j)){
    				if(count!=0){
    					String countStr = String.valueOf(count);
    					char preChar = preStr.charAt(j-1);
    				    sb.append(countStr);
    				    sb.append(preChar);
    				}
    				count=1;
    			}
    		}
    		callWay[i]=sb.toString();
    	}
        return callWay[n-1];
    }
    
    public static void main(String[] args) {
		new Test1().countAndSay(4);
	}

}
