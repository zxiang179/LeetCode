package zx.leetcode.apri;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import org.junit.Test;

/**
 * 496. Next Greater Element I
 * @author Carl_Hugo
 *
 */
public class Test4 {
	
	/**
	 * suppose we have a decreasing sequence followed by a greater number
	 * for example [5,4,3,2,1,6]then the greater num 6 is the next greater element for all previous nums in the sequence
	 * 
	 * we use a stack to keep a decreasing sub-sequence,whenever we see a num x greater than stack.peek(),
	 * we pop all elements less than x and for all the popped ones, their next greater element is x
	 * for example[9,8,7,3,2,1,6] the stack will first contain [9,8,7,3,2,1] and then we see 6 is grater than 1
	 * so we pop 1 2 3 whose next greater element should be 6
	 * @param findNums
	 * @param nums
	 * @return
	 */
	
    public int[] nextGreaterElement(int[] findNums, int[] nums) {
    	Map<Integer,Integer> map = new HashMap<Integer,Integer>();
    	Stack<Integer> stack = new Stack<Integer>();
    	for(int num:nums){
    		while(!stack.isEmpty()&&stack.peek()<num){
    			//当前栈内的元素小于数组中的当前值，将栈内的元素出栈，并将其next greater元素存入hashMap中
    			map.put(stack.pop(), num);
    		}
    		stack.push(num);
    	}
    	for(int i=0;i<findNums.length;i++){
    		findNums[i] = map.getOrDefault(findNums[i], -1); 
    	}
        return findNums;
    }
    
    @Test
    public void test(){
    	Test4 test4 = new Test4();
    	int[] nums1={2,4};
    	int[] nums2={1,2,3,4};
    	int[] result = new int[2];
    	result = test4.nextGreaterElement(nums1, nums2);
    	for(int num:result){
    		System.out.println(num);
    	}
    	
    }

}
