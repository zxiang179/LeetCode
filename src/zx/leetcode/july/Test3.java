package zx.leetcode.july;

import java.util.ArrayList;
import java.util.List;

/**
 * 624. Maximum Distance in Arrays
 * @author Carl_Hugo
 * @date 2017年7月3日
 */
public class Test3 {
	
	/**
	 * 查找队列中元素的极差
	 * @param arrays
	 * @return
	 */
    public int maxDistance(List<List<Integer>> arrays) {
        int min = arrays.get(0).get(0);
        int max = arrays.get(0).get(arrays.get(0).size()-1);
        int result = Integer.MIN_VALUE;
        for(int i=1;i<arrays.size();i++){
        	result = Math.max(result, Math.abs(min-arrays.get(i).get(arrays.get(i).size()-1)));
        	result = Math.max(result, Math.abs(max-arrays.get(i).get(0)));
        	min = Math.min(min, arrays.get(i).get(0));
        	max = Math.max(max, arrays.get(i).get(arrays.get(i).size()-1));
        }
        return result;
    }

}
