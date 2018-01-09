package zx.leetcode.chicken.Aug;
/**
 * 67. Add Binary
 * @author Carl_Hugo
 * @date 2017年8月3日
 */
public class Test2 {
	
	public String addBinary(String a, String b) {
		StringBuilder sb = new StringBuilder();
		int i=a.length()-1;
		int j=b.length()-1;
		int carry = 0;
		while(i>=0||j>=0){
			int sum = carry;
			if(j>=0)sum+=b.charAt(j--)-'0';
			if(i>=0)sum+=a.charAt(i--)-'0';
			sb.append(sum%2);
			carry=sum/2;
		}
		if(carry!=0)sb.append(carry);
		return sb.reverse().toString();
	}
    
	public String addBinary2(String a, String b) {
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
