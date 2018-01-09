package zx.leetcode.chicken.dec;
/**
 * 693. Binary Number with Alternating Bits
 * @author Carl_Hugo
 * 2017年12月6日 下午2:58:31
 */
public class Binary_Number_with_Alternating_Bits {
	
	public boolean hasAlternatingBits(int n) {
        return Integer.toBinaryString(n).matches("(10)*1?");
    }

}
