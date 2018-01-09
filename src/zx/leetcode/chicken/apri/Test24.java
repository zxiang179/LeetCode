package zx.leetcode.chicken.apri;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 504. Base 7
 * @author Carl_Hugo
 *
 */
public class Test24 {
	
    public String convertToBase7(int num) {
    	if(num==0)return "0";
    	boolean positive = true;
    	int temp = num;
    	Stack stack = new Stack();
    	String res = "";
    	if(temp<0){
    		positive = false;
    		temp = temp*(-1);
    	}
    	while(temp>0){
    		stack.push(temp%7);
    		temp=temp/7;
    	}
    	while(!stack.isEmpty()){
    		res +=stack.pop();
    	}
    	return positive?res:('-'+res);
    }
    
    public static void main(String[] args) {
		Test24 test24 = new Test24();
		System.out.println(test24.convertToBase7(-7));
	}

}
