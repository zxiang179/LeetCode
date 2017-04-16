package zx.leetcode.apri;
/**
 * 557. Reverse Words in a String III
 * @author Carl_Hugo
 *
 */
public class Test13 {
	
	/**
	 * Input: "Let's take LeetCode contest"
     * Output: "s'teL ekat edoCteeL tsetnoc"
	 * @param s
	 * @return
	 */
    public String reverseWords(String s) {
        String[] splitStr = s.split("\\s");
        for(int i=0;i<splitStr.length;i++){
        	splitStr[i]=reverseStr(splitStr[i]);
        }
        String resultStr = "";
        for(int i=0;i<splitStr.length;i++){
        	if(i!=splitStr.length-1){
        		resultStr = resultStr + splitStr[i]+" ";
        	}else{
        		resultStr = resultStr + splitStr[i];
        	}
        }
        return resultStr;
    }
    
    public String reverseStr(String s){
    	int i=0,j=0;
    	char[] charArray = s.toCharArray();
    	char temp;
    	for(i=0,j=charArray.length-1;i<j;i++,j--){
    		temp = charArray[i];
    		charArray[i] = charArray[j];
    		charArray[j] = temp;
    	}
    	String result = String.valueOf(charArray);
    	return result;
    }

	public static void main(String[] args) {
		Test13 test13 = new Test13();
		System.out.println(test13.reverseWords("Let's take LeetCode contest"));
	}

}
