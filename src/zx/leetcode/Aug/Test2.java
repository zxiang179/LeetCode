package zx.leetcode.Aug;
/**
 * 67. Add Binary
 * @author Carl_Hugo
 * @date 2017年8月3日
 */
public class Test2 {
    
	public String addBinary(String a, String b) {
        Integer aValue = Integer.valueOf(a, 2);
        Integer bValue = Integer.valueOf(b, 2);
        Integer sum = aValue+bValue;
        String sumBinary = Integer.toBinaryString(sum);
        return sumBinary;
	}
	
	public static void main(String[] args) {
		new Test2().addBinary("11", "1");
	}
}
