package zx.leetcode.dog.apri;

import java.util.Collections;
import java.util.PriorityQueue;

public class Sliding_Window_Median_480 {

	public double[] medianSlidingWindow(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
        double[] resArr = new double[nums.length-k+1];
        boolean isOdd = true;
        if(k%2==0)isOdd = false;
        for(int i=0;i<nums.length;i++) {
        	if(i>=k) {
        		pq.remove(nums[i-k]);
        	}
        	pq.offer(nums[i]);
        	if(i+1>=k) {
                PriorityQueue<Integer> pqTemp = new PriorityQueue<>(pq);
        		if(isOdd) {
        			for(int j=0;j<k/2;j++) {
        				pqTemp.poll();
        			}
        			resArr[i-k+1] = pqTemp.poll();
        		}else {
        			for(int j=0;j<k/2-1;j++) {
        				pqTemp.poll();
        			}
        			double firstM = pqTemp.poll();
        			double secondM = pqTemp.poll();
        			resArr[i-k+1] = (firstM+secondM)*0.5;
        		}
        	}
        }
        return resArr;
	}
	
	public static void main(String[] args) {
		new Sliding_Window_Median_480().medianSlidingWindow(new int[] {2147483647,2147483647}, 2);
	}

}
