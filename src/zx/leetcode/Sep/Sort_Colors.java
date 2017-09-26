package zx.leetcode.Sep;
/**
 * 75. Sort Colors
 * @author Carl_Hugo
 * 2017年9月26日 上午9:42:42
 */
public class Sort_Colors {
	
	public void sortColors(int[] nums) {
		int zero = 0;
		int second = nums.length-1;
		for(int i=0;i<=second;i++){
			while(nums[i]==2&&i<second){
				int temp = nums[i];
				nums[i]=nums[second];
				nums[second]=temp;
				second--;
			}
			while(nums[i]==0&&i>zero){
				int temp = nums[i];
				nums[i] = nums[zero];
				nums[zero]=temp;
				zero++;
			}
		}
        System.out.println();
    }

	public static void main(String[] args) {
		new Sort_Colors().sortColors(new int[]{2,1,2,1,1,0,0,1,2});
	}
}
