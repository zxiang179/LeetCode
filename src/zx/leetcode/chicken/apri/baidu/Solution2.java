package zx.leetcode.chicken.apri.baidu;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution2 {
	
    ArrayList<Integer> fence(int numOfPlanks, int numOfColors, int numOfSteps,
                             int[][] steps)
    {
    	ArrayList<Integer> resList = new ArrayList<Integer>();
    	int[] blanks = new int[numOfPlanks+1];
    	Arrays.fill(blanks, 0);
    	int[] res = new int[numOfSteps];
    	for(int i=0;i<numOfSteps;i++) {
    		int left = steps[i][0];
    		int right = steps[i][1];
    		for(int j=left;j<=right;j++) {
    			blanks[j] = steps[i][2];
    		}
    		resList.add(countMaxRepeat(blanks,numOfColors)); 
    	}
    	return resList;
    	
    }
    
    private int countMaxRepeat(int[] blanks,int numOfColors) {
    	int max = 0;
    	for(int i=0;i<=numOfColors;i++) {
    		int tempCount = 0;
    		for(int j =1;j<blanks.length;j++) {
    			if(i==blanks[j]) {
    				tempCount++;
    			}
    		}
    		if(tempCount>=max) {
    			max = tempCount;
    		}
    	}
		return max;
	}

    public static void main(String[] args) {
		new Solution2().fence(5, 5, 4, new int[][] {{2,3,5},{4,5,2},{4,5,1},{1,5,4}});
	}
	

}
