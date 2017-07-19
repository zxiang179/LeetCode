package zx.leetcode.july;
/**
 * 209. Minimum Size Subarray Sum
 * @author Carl_Hugo
 */
public class Test25 {
	
	/**
	 * 滑动窗口
	 * @param s
	 * @param nums
	 * @return
	 */
    public int minSubArrayLen(int s, int[] nums) {
        int minLen = Integer.MAX_VALUE;
        int left = 0;
        int right = 0;
        int sum = 0;
        if(nums.length==0||nums==null)return 0;
        while(right<nums.length&&left<=right){
        	for(int i=left;i<=right;i++){
        		sum+=nums[i];
        	}
        	if(sum<s){
        		right++;
        		sum=0;
        	}else{
        		if(minLen>(right-left+1))minLen = right-left+1;
        		left++;
        		sum=0;
        	}
        }
        if(minLen==Integer.MAX_VALUE)return 0;
        return minLen;
    }
    
    public static void main(String[] args) {
		new Test25().minSubArrayLen(7, new int[]{2,3,1,2,4,3});
	}

}
