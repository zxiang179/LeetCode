package zx.leetcode.chicken.may;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 575. Distribute Candies
 * @author Carl_Hugo
 * @date 2017年5月7日
 */
public class Test13 {
	
	/**
	 * Input: candies = [1,1,2,2,3,3]
     * Output: 3
     * Explanation:
     * There are three different kinds of candies (1, 2 and 3), and two candies for each kind.
     * Optimal distribution: The sister has candies [1,2,3] and the brother has candies [1,2,3], too. 
     * The sister has three different kinds of candies. 
	 * @param candies
	 * @return
	 */
    public int distributeCandies(int[] candies) {
    	Set<Integer> set = new HashSet<Integer>();
    	int max = 0;
    	for(int i:candies){
    		set.add(i);
    	}
    	if(set.size()>=(candies.length/2)){
    		max=candies.length/2;	
    	}else{
    		max=set.size();	
    	}
        return max;
    }

}
