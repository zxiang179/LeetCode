package zx.leetcode.may;

import java.util.Arrays;
import java.util.Stack;

/**
 * 503. Next Greater Element II
 * @author Carl_Hugo
 * @date 2017年5月18日
 */
public class Test23 {
	
	/**
	 * Input: [1,2,1]
	 * Output: [2,-1,2]
	 * Explanation: The first 1's next greater number is 2; 
	 * The number 2 can't find next greater number; 
	 * The second 1's next greater number needs to search circularly, which is also 2.
	 * @param nums
	 * @return
	 */
    public int[] nextGreaterElements(int[] nums) {
    	int n = nums.length;
        int[] res= new int[n];
        //stack用于记录存入元素的索引
        Stack<Integer> stack = new Stack<Integer>();
        Arrays.fill(res, -1);
        for(int i=0;i<n*2;i++){
        	int num = nums[i%n];
        	while(!stack.isEmpty()&&nums[stack.peek()]<num){
        		res[stack.pop()]=num;
        	}
        	if(i<n)stack.push(i);
        }
        return res;
    }
    
    public static void main(String[] args) {
		new Test23().nextGreaterElements(new int[]{1,2,1});
	}

}
