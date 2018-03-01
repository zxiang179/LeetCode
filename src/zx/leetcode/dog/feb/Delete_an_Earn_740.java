package zx.leetcode.dog.feb;

public class Delete_an_Earn_740 {
	
	/**
	 * 当选取一个数时需要将它所有出现的数都选上，可以将它所出现的数放在数组的某一个位置(求和)
	 * 最优子结构
	 * 对于每个桶有取或者不取两种情况
	 * 状态转移方程
	 * take[i]=untake[i-1]+values[i]
	 * untake[i]=max(take[i-1],untake[i-1])
	 * 边界
	 * take[0]=0;
	 * untake[0]=0;
	 * @param nums
	 * @return
	 */
	public int deleteAndEarn(int[] nums) {
		int[] values = new int[10001];
		int[] take = new int[10001];
		int[] untake = new int[10001];
		for(int num:nums){
			values[num]+=num;
		}
		take[0]=0;
		untake[0]=0;
		for(int i=1;i<10001;i++){
			take[i]=untake[i-1]+values[i];
			untake[i]=Math.max(take[i-1],untake[i-1]);
		}
        return Math.max(take[10000], untake[10000]);
    }
	
	public static void main(String[] args) {
		new Delete_an_Earn_740().deleteAndEarn(new int[]{2, 2, 3, 3, 3, 4});
	}

}
