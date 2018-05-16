package zx.leetcode.dog.nowcoder.sword2offer;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Solution5 {
	
	public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
		PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>();
		ArrayList<Integer> resList = new ArrayList<Integer>();
		if(k>input.length)return resList;
		for(int i=0;i<input.length;i++) {
			priorityQueue.add(input[i]);
		}
        for(int i=0;i<k;i++) {
        	resList.add(priorityQueue.poll());
        }
		return resList;
    }
	
	public static void main(String[] args) {
		new Solution5().GetLeastNumbers_Solution(new int[] {4,5,1,6,2,7,3,8}, 4);
	}

}
