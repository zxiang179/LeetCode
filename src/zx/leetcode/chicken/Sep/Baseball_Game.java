package zx.leetcode.chicken.Sep;

import java.util.Stack;

/**
 * 682. Baseball Game
 * @author Carl_Hugo
 * 2017年9月25日 下午3:41:52
 */
public class Baseball_Game {
	
	public int calPoints(String[] ops) {
		Stack<Integer> validStack = new Stack<Integer>();
		int sum = 0;
		
		for(String str : ops){
			if("+".equals(str)){
				Integer secondValid = validStack.pop();
				Integer firstValid;
				if(validStack.isEmpty()){
					firstValid = 0;
				}else{
					firstValid = validStack.pop();
				}
				Integer tempSum = secondValid + firstValid;
				validStack.push(firstValid);
				validStack.push(secondValid);
				validStack.push(tempSum);
				sum+= tempSum;
			}else if("C".equals(str)){
				Integer popInt = validStack.pop();
				sum -= popInt;
			}else if("D".equals(str)){
				int popInt = validStack.peek();
				validStack.push(popInt*2);
				sum += popInt*2;
			}else{
				Integer val = Integer.valueOf(str);
				validStack.push(val);
				sum += val;
			}
		}
		System.out.println(sum);
        return sum;
    }
	
	public static void main(String[] args) {
		new Baseball_Game().calPoints(new String[]{"36","28","70","65","C","+","33","-46","84","C"});
//		new Baseball_Game().calPoints(new String[]{"5","2","C","D","+"});
	}

}
