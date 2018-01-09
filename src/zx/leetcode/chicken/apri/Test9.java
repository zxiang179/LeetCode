package zx.leetcode.chicken.apri;
/**
 * 520. Detect Capital
 * @author Carl_Hugo
 *
 */
public class Test9 {
	
	/**
	 * We define the usage of capitals in a word to be right when one of the following cases holds:
	 * 1 All letters in this word are capitals, like "USA".
	 * 2 All letters in this word are not capitals, like "leetcode".
	 * 3 Only the first letter in this word is capital if it has more than one letter, like "Google".
	 * @param word
	 * @return
	 */
	public boolean detectCapitalUse(String word) {
	    char[] charArray = word.toCharArray();
	    //true represent right
	    boolean flag=true;
	    //true represent Upper
	    boolean firstJudge = false;
	    //if count=-(n-1) 均为小写 count=n-1 均为大写
	    int count=0;
	    firstJudge = Character.isUpperCase(charArray[0]);
	    //如果第一个字母是小写，后面只能均为小写
	    //如果第一个字母是大写，后面可以均为大写或均为小写
	    for(int i=1;i<charArray.length;i++){
	    	if(firstJudge==false){
	    		if(Character.isUpperCase(charArray[i])){
	    			flag=false;
	    			break;
	    		}
	    	}
	    	if(firstJudge==true){
	    		
	    		if(Character.isUpperCase(charArray[i])){
	    			count++;
	    		}
	    		if(Character.isUpperCase(charArray[i])==false){
	    			count--;
	    		}
	    	}
	    }
	    if(firstJudge==false&&flag==true)return true;
	    if(firstJudge==true){
	    	if(count==charArray.length-1||count==-(charArray.length-1)){
	    		return true;
	    	}
	    }
	    return false;
    }
	
	public boolean detectCapitalUse2(String word) {
	    return word.matches("[A-Z]+|[a-z]+|[A-Z][a-z]+");
	}
	
}
