package zx.leetcode.chicken.apri;
/**
 * 268. Missing Number
 * @author Carl_Hugo
 */
public class Test12 {
	
	/**
	 * 使用hash表
	 * @param nums
	 * @return
	 */
    public int missingNumber(int[] nums) {
        int length = nums.length;
        int[] map = new int[length+1];
        int missingNum=0;
        for(int i=0;i<nums.length;i++){
        	map[nums[i]]=1;
        }
        for(int i=0;i<map.length;i++){
        	if(map[i]==0){
        		missingNum = i;
        	}
        }
        return missingNum;
    }
	
	public static void main(String[] args) {
		Test12 test12 = new Test12();
		System.out.println(test12.missingNumber(new int[]{0,1,3}));
	}

}
