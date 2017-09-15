package zx.leetcode.Sep;
/**
 * 674. Longest Continuous Increasing Subsequence
 * @author Carl_Hugo
 * 2017年9月15日 下午9:54:12
 */
public class Longest_Continuous_Increasing_Subsequence {

    public int findLengthOfLCIS(int[] nums) {
    	if(nums==null||nums.length==0)return 0;
    	if(nums.length==1)return 1;
    	int count = 1;
    	int max = 0;
    	for(int i=1;i<nums.length;){
    		if(nums[i]>nums[i-1]){
    			count++;
    			if(count>max){
    				max = count;
    			}
    		}else{
    			if(count>max){
    				max = count;
    			}
    			count = 1;
    		}
    		i++;
    	}
        return max;
    }

    public static void main(String[] args) {
		System.out.println(
				new Longest_Continuous_Increasing_Subsequence().
				findLengthOfLCIS(new int[]{1,3,5,7}));
	}
}
