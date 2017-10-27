package zx.leetcode.restart;

import java.util.Stack;

public class Valid_Parentheses {

	public boolean isValid(String s) {
		Stack<Character> stack = new Stack<Character>();
		char[] charArr = s.toCharArray();
		if((charArr.length&1)==1)return false;
		for(int i=0;i<charArr.length;i++){
			char c = charArr[i];
			if(c=='('||c=='{'||c=='['){
				stack.push(c);
			}else if(c==')'||c=='}'||c==']'){
				if(stack.isEmpty()){
					return false;
				}else{
					char lc = stack.pop();
					if((c==')'&&lc=='(')||(c==']'&&lc=='[')||(c=='}'&&lc=='{')){
						continue;
					}else{
						return false;
					}	
				}
			}else{
				return false;
			}
		}
		return stack.isEmpty()?true:false;
    }
	
}
