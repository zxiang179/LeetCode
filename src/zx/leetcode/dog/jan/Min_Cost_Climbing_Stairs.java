package zx.leetcode.dog.jan;

import org.junit.Test;

public class Min_Cost_Climbing_Stairs {
	
	public int minCostClimbingStairs(int[] cost) {
		if(cost==null||cost.length==0)return 0;
		if(cost.length==1)return cost[0];
		int totalCost = 0;
		//通过数组记录到每一级台阶的最少cost，每一级台阶的最少cost只和上一步的消耗有关
		int[] mc = new int[cost.length+1];
		mc[0] = cost[0];
		mc[1] = cost[1];
		
        for(int i=2;i<=cost.length;i++){
        	int costV = (i==cost.length)?0:cost[i];
        	mc[i] = Math.min(mc[i-1]+costV, mc[i-2]+costV);
        }
		return mc[cost.length];
    }
	
	@Test
	public void test(){
		int[] arr = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
		System.out.println(minCostClimbingStairs(arr));
	}

}
