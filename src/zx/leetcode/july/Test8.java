package zx.leetcode.july;
/**
 * 553. Optimal Division
 * @author Carl_Hugo
 * @date 2017年7月6日
 */
public class Test8 {
	
	/**
	 * @param nums
	 * @return
	 */
    public String optimalDivision(int[] nums) {
    	StringBuilder builder = new StringBuilder();
        builder.append(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            if (i == 1 && nums.length > 2) {
                builder.append("/(").append(nums[i]);
            } else {
                builder.append("/").append(nums[i]);
            }
        }
        
        return nums.length > 2 ? builder.append(")").toString() : builder.toString();
    }
    
    public static void main(String[] args) {
		System.out.println(new Test8().optimalDivision(new int[]{1000,100,50,10,2}));
	}

}
