package zx.leetcode.chicken.Sep;
/**
 * 12. Integer to Roman
 * @author Carl_Hugo
 * 2017年9月7日 下午8:30:51
 */
public class Integer_to_Roman {
	
	/**
	 * input range from 1 to 3999
	 * @param num
	 * @return
	 */
    public String intToRoman(int num) {
        String[] symbol = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        int[]    value  = {1000,900,500, 400, 100, 90,  50,40 , 10,  9 ,5,   4  , 1};
        String str = "";
        for(int i=0;num!=0;i++){
        	while(num>=value[i]){
        		num-=value[i];
        		str+=symbol[i];
        	}
        }
        return str;
    }
    
    public static void main(String[] args) {
		System.out.println(new Integer_to_Roman().intToRoman(3578));
	}

}
