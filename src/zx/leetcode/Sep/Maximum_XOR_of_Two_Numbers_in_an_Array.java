package zx.leetcode.Sep;

import java.util.HashSet;
import java.util.Set;

/**
 * 144. Binary Tree Preorder Traversal
 * @author Carl_Hugo
 * @date 2017年9月2日
 */
public class Maximum_XOR_of_Two_Numbers_in_an_Array {

    public int findMaximumXOR(int[] nums) {
    	int max = 0;
    	int flag = 0;
    	
    	//from left to right
    	for(int i=31;i>=0;i--){
    		Set<Integer> prefixSet = new HashSet<Integer>();
    		//flag : 1111000
    		flag = flag | (1<<i);
    		for(int num:nums){
    			prefixSet.add(num&flag);
    		}
    		
    		//tmp , max : 10101000000 ,add more 1
    		int tmp = max | (1<<i);
    		for(int prefix:prefixSet){
    			if(prefixSet.contains(tmp^prefix)){
    				max = tmp;
    				break;
    			}
    		}
    	}
    	return max;
    }
	
}
