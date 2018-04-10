package zx.leetcode.dog.apri;

import java.util.Collections;
import java.util.PriorityQueue;

public class Sliding_Window_Maximum_239 {

	public int[] maxSlidingWindow(int[] nums, int k) {
		if(nums==null||nums.length==0)return new int[0];
		int[] resArr = new int[nums.length-k+1];
		PriorityQueue<Integer> priorityQueue = new PriorityQueue(Collections.reverseOrder());
		for(int i=0;i<nums.length;i++) {
			if(i>=k) {
				//把窗口左边的数字删除
				priorityQueue.remove(nums[i-k]);
			}
			//添加新的数
			priorityQueue.offer(nums[i]);
			//堆顶就是窗口的最大值
			if(i+1>=k)resArr[i-k+1] = priorityQueue.peek();
		}
		return resArr;
	}
	
	public static void main(String[] args) {
		new Sliding_Window_Maximum_239().maxSlidingWindow(new int[] {1,3,-1,-3,5,3,6,7}, 3);
	}

}
