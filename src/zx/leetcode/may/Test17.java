package zx.leetcode.may;
/**
 * 537. Complex Number Multiplication
 * @author Carl_Hugo
 * @date 2017年5月8日
 */
public class Test17 {
	
    /**
     * Input: "1+1i", "1+1i"
     * Output: "0+2i"
     * Explanation: (1 + i) * (1 + i) = 1 + i2 + 2 * i = 2i, and you need convert it to the form of 0+2i.
     * The input strings will not have extra blank.
     * The input strings will be given in the form of a+bi, 
     * where the integer a and b will both belong to the range of [-100, 100]. 
     * And the output should be also in this form.
     * (a+bi)(c+di)=(ac-bd)+(ad+bc)i
     * @param a
     * @param b
     * @return
     */
	public String complexNumberMultiply(String a, String b) {
		int[] res = new int[4];
		res = parser(a,b);
		int font = res[0]*res[2]-res[1]*res[3];
		int end = res[0]*res[3]+res[1]*res[2];
		
		String fontStr="";
		String endStr="";
		String finalStr="";
		if(font==0){
			fontStr="0"+"+";
		}else{
			fontStr=String.valueOf(font)+"+";
		}
		endStr=String.valueOf(end)+"i";
		return finalStr=fontStr+endStr;
    }
	
	public int[] parser(String a,String b){
		int[] res = new int[4];
		String[] splitA = a.split("\\+");
		res[0]=Integer.valueOf(splitA[0]);
		res[1]=Integer.valueOf(splitA[1].replace("i",""));
		
		String[] splitB =b.split("\\+");
		res[2]=Integer.valueOf(splitB[0]);
		res[3]=Integer.valueOf(splitB[1].replace("i",""));
		
		return res;
	}
	

}
