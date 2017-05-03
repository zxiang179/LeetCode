package zx.leetcode.may;

import java.util.Stack;

/**
 * 232. Implement Queue using Stacks
 * @author Carl_Hugo
 * @date 2017年5月3日
 */
public class MyQueue {
	
	Stack<Integer> input = new Stack<Integer>();
	Stack<Integer> output = new Stack<Integer>();
    /** Initialize your data structure here. */
    public MyQueue() {
    	input = new Stack<Integer>();
    	output = new Stack<Integer>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        input.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
    	peek();
    	return output.pop();
    }
    
    /** Get the front element. */
    public int peek() {
    	if(output.isEmpty()){
    		while(!input.isEmpty()){
    			output.push(input.pop());
    		}
    	}
    	return output.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return output.isEmpty()&&input.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */