package zx.leetcode.dog.nowcoder.sword2offer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class Solution1 {
	
	public ArrayList<Integer> FindNumbersWithSum(int [] array,int sum) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int num:array){
            if(!map.containsKey(sum-num)){
                map.put(num,sum-num);
            }else{
                list.add(sum-num);
                list.add(num);
            }
        }
        int length = list.size();
        ArrayList<Integer> resList = new ArrayList<Integer>();
        if(length!=0) {
        	resList = new ArrayList<Integer>(list.subList(length-2,length));	
        }
        
        return resList;
    }

	@Test
	public void test() {
		System.out.println(new Solution1().FindNumbersWithSum(new int[] {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20}, 21));
	}
}


