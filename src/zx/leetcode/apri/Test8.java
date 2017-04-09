package zx.leetcode.apri;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * 448. Find All Numbers Disappeared in an Array
 * @author Carl_Hugo
 *
 */
public class Test8 {
	
	/**
	 * Could you do it without extra space and in O(n) runtime? 
	 * 第一遍遍历，将nums[i]的值放到特定位置并+n
	 * 第二遍遍历，如果大于n则表示遍历到过，否则加入结果队列		
	 * @param nums
	 * @return
	 */
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        List<Integer> resultList = new ArrayList<Integer>();
        for(int i=0;i<n;i++)nums[(nums[i]-1)%n]+=n;
        for(int i=0;i<n;i++)if(nums[i]<=n)resultList.add(i+1);
        return resultList;
    }
    
    @Test
    public void test(){
    	Test8 test8 = new Test8();
    	int[] nums={4,3,2,7,8,2,3,1};
    	List<Integer> list = new ArrayList<Integer>();
    	list=test8.findDisappearedNumbers(nums);
    	System.out.println(list.toString());
    }

}
