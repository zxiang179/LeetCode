package zx.leetcode.chicken.july;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 394. Decode String
 * @author Carl_Hugo
 *
 */
public class Test20 {
	
	/**
	 * s = "3[a]2[bc]", return "aaabcbc".
     * s = "3[a2[c]]", return "accaccacc".
     * s = "2[abc]3[cd]ef", return "abcabccdcdcdef".
	 * @param s
	 * @return
	 */
	public String decodeString(String s) {
		String res = "";
		Stack<Integer> countStack = new Stack<Integer>();
		Stack<String> resStack = new Stack<String>();
		int length = s.length();
		int index=0;
		while(index<length){
			if(Character.isDigit(s.charAt(index))){
				int count = 0;
				while(Character.isDigit(s.charAt(index))){
					count = count*10 + (s.charAt(index)-'0');
					index++;
				}
				countStack.push(count);
			}else if(s.charAt(index)=='['){
				//将左括号之前的字符串存入stack
				resStack.push(res);
				res = "";
				index++;
			}else if(s.charAt(index)==']'){
				StringBuilder tempSB = new StringBuilder(resStack.pop());
				int repeatTimes = countStack.pop();
				for(int j=0;j<repeatTimes;j++){
					tempSB.append(res);
				}
				res = tempSB.toString();
				index++;
			}else{
				res+=s.charAt(index);
				index++;
			}
		}
		return res;
		
    }
	
	
    public String decodeString2(String s) {
    	StringBuffer sb = new StringBuffer();
    	String res=null;
    	Stack<Character> stack = new Stack<Character>();
    	for(int i=0;i<s.length();i++){
    		Character c = s.charAt(i);
    		if(c!=']'){
    			stack.push(c);
    		}else{
    			List<Character> subList = new ArrayList<Character>();
    			List<Character> times =  new ArrayList<Character>();
    			while(!stack.isEmpty()){
    				Character popChar = stack.pop();
    				if(popChar>='a'&&popChar<='z'){
    					subList.add(0, popChar);
    				}else if(popChar>='0'&&popChar<='9'){
    					times.add(0,popChar);
    				}
    			}
    			int timesSize = times.size();
    			int finalTimes = 0;
    			for(int j=0;j<timesSize;j++){
    				finalTimes+=Math.pow(10, timesSize-j-1)*Integer.valueOf(times.get(j).toString());
    			}
    			for(int k=0;k<finalTimes;k++){
    				for(int l=0;l<subList.size();l++){
    					sb.append(subList.get(l));
    				}
    			}
    		}
    	}
    	res = sb.toString();
    	return res;
    }
    
    public static void main(String[] args) {
    	new Test20().decodeString("3[a]2[bc]");
	}

}
