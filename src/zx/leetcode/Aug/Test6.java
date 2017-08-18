package zx.leetcode.Aug;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
/**
 * 658. Find K Closest Elements
 * @author Carl_Hugo
 * @date 2017年8月18日
 */
public class Test6 {
	
	/**
	 * find the first num which is equal to or greater than x in arr
	 * then we determine the indices of the start and end of a subarray in arr
	 * @param arr
	 * @param k
	 * @param x
	 * @return
	 */
    public List<Integer> findClosestElements(List<Integer> arr, int k, int x) {
    	int index = Collections.binarySearch(arr, x);
    	if(index<0)index=-(index+1);
    	int i = index-1,j=index;
    	while(k-->0){
    		if(i<0||(j<arr.size()&&Math.abs(arr.get(i)-x)>Math.abs(arr.get(j)-x)))j++;
    		else i--;
    	}
    	return arr.subList(i+1, j);
        
    }
    
    public static void main(String[] args) {
    	int[] arr = {1,2,3,4,5};
    	List<Integer> list = Arrays.asList(0,0,1,2,3,3,4,7,7,8);
		List<Integer> resList = new Test6().findClosestElements(list, 3, 5);
		System.out.println();
	}

}
