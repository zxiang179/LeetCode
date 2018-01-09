package zx.leetcode.chicken.Sep.iqiyi;

import java.util.Scanner;
import java.util.Stack;

public class Main2 {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String inputStr = scanner.nextLine();
		Stack<Character> stack = new Stack<Character>();
		for(int i=0;i<inputStr.length();i++){
			char c = inputStr.charAt(i);
			stack.push(c);
		}
		int maxCount = 0;
		int first = 1;
		while(!stack.isEmpty()){
			
			if(stack.peek()==')'&&first==1){
				first = -1;
				int tempCount = 0;
				while(stack.pop()==')'){
					tempCount++;
				}
				first = 1;
				maxCount = Math.max(tempCount, maxCount);
			}else if(stack.peek()=='('){
				first = 1;
				stack.pop();
			}
		}
		System.out.println(maxCount);
		
	}

}
