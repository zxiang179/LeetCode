package zx.leetcode.july;
/**
 * 645. Set Mismatch
 * @author Carl_Hugo
 * @date 2017年7月23日
 */
public class Test27 {
	
    public int[] findErrorNums(int[] nums) {
    	int len = nums.length;
    	int[] hash = new int[len+1];
    	int duplicate = 0;
    	int loss = 0;
    	for(int i=0;i<len;i++){
    		hash[nums[i]]++;
    	}
    	for(int i=1;i<len+1;i++){
    		if(hash[i]==2)duplicate=i;
    		if(hash[i]==0)loss = i;
    	}
        int[] res = new int[2];
        if(duplicate>=loss){
        	res[0]=loss;
        	res[1]=duplicate;		
        }else{
        	res[0]=duplicate;
        	res[1]=loss;
        }
        return res;
    }

}
