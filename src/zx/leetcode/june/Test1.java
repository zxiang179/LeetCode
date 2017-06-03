package zx.leetcode.june;

import java.awt.List;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * 599. Minimum Index Sum of Two Lists
 * @author Carl_Hugo
 * @date 2017年6月3日
 */
public class Test1 {
	/**
	 * You need to help them find out their common interest with the least list index sum. 
	 * If there is a choice tie between answers, output all of them with no order requirement. 
	 * You could assume there always exists an answer.
	 * @param list1
	 * @param list2
	 * @return
	 */
    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String,Integer> map = new HashMap<String,Integer>();
        LinkedList<String> res = new LinkedList<String>();
        int min = Integer.MAX_VALUE;
        for(int i=0;i<list1.length;i++)map.put(list1[i], i);
        for(int i=0;i<list2.length;i++){
        	Integer j = map.get(list2[i]);
        	if(j!=null&&i+j<=min){
        		if(i+j<min){
        			res = new LinkedList<String>();
        			min=i+j;
        		}
        		res.add(list2[i]);
        	}
        }
        
        return res.toArray(new String[res.size()]);
    }

}
