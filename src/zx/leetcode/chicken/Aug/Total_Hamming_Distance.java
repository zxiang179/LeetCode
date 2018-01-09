package zx.leetcode.chicken.Aug;
/**
 * 477. Total Hamming Distance
 * @author Carl_Hugo
 * @date 2017年8月29日
 */
public class Total_Hamming_Distance {
	
	
	public int totalHammingDistance(int[] nums) {
		int n = 31;
		int len = nums.length;
		int[] countOfOnes = new int[n];
		for(int i=0;i<len;i++){
			for(int j=0;j<n;j++){
				countOfOnes[j]+=(nums[i]>>j)&1;
			}
		}
		int sum = 0;
		//某一位不为1就是0，出现1的个数和出现0的个数相乘则为所有可能的情况
		for(int count:countOfOnes){
			sum+=count*(len-count);
		}
		return sum;
	}
	
	public static void main(String[] args) {
		System.out.println(new Total_Hamming_Distance().totalHammingDistance2(new int[]{4,14,2}));
	}
	
    /**
     * count binary distances
     * @param nums
     * @return
     */
	public int totalHammingDistance2(int[] nums) {
        int count = 0;
        for(int i=0;i<nums.length;i++){
        	for(int j=i+1;j<nums.length;j++){
        		count+=computeDistance(nums[i],nums[j]);
        	}
        }
        return count;
    }
	
	public int computeDistance(int a,int b){
		return Integer.bitCount(a^b);
	}

}
