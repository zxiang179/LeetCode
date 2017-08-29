package zx.leetcode.Aug;

import java.util.HashMap;
import java.util.Map;

/**
 * 454. 4Sum II
 * @author Carl_Hugo
 * @date 2017年8月29日
 */
public class four_Sum_II {
	
	/**
	 * 
	 * @param A
	 * @param B
	 * @param C
	 * @param D
	 * @return
	 */
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
    	int res = 0;
    	Map<Integer,Integer> map = new HashMap<Integer,Integer>();
    	for(int i=0;i<C.length;i++){
    		int sum = 0;
    		for(int j=0;j<D.length;j++){
    			sum = C[i]+D[j];
    			map.put(sum, map.getOrDefault(sum, 0)+1);
    		}
    	}
    	
    	for(int i=0;i<A.length;i++){
    		int abSum = 0;
    		for(int j=0;j<B.length;j++){
    			abSum = A[i]+B[j];
    			res+=map.getOrDefault(-abSum, 0);
    		}
    	}
        return res;
    }

}
