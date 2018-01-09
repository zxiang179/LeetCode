package zx.leetcode.chicken.apri;

import org.junit.Test;

/**
 * 485. Max Consecutive Ones
 * @author Carl_Hugo
 *
 */
public class Test7 {
	
    public int findMaxConsecutiveOnes(int[] nums) {
    	int count=0;
    	int max=0;
    	if(nums.length==0||nums==null)return 0;
    	for(int i=0;i<nums.length;i++){
    		if(nums[i]==1){
    			count++;
    		}
    		if(nums[i]==0||i==nums.length-1){
    			if(count>max){
    				max=count;
    			}
    			count=0;
    		}
    	}
        return max;
    }
    
    @Test
    public void test(){
    	int[] nums={1,1,0,1,1,1};
    	Test7 test7 = new Test7();
    	System.out.println(test7.findMaxConsecutiveOnes(nums));
    }

}
