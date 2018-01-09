package zx.leetcode.chicken.may;
/**
 * 338. Counting Bits
 * @author Carl_Hugo
 * @date 2017年5月28日
 */
public class Test30 {
	
    public int[] countBits(int num) {
        int[] res = new int[num+1];
        int offset = 1;
        for(int index=1;index<num+1;index++){
        	if(offset*2==index){
        		offset*=2;
        	}
        	res[index]=res[index-offset]+1;
        }
        return res;
    }

}
