package zx.leetcode.chicken.Sep;
/**
 * 672. Bulb Switcher II
 * @author Carl_Hugo
 * 2017年9月12日 上午10:56:37
 */
public class Bulb_Switcher_II {
	
	public int flipLights(int n, int m) {
        if(m==0)return 1;
        if(n==1)return 2;
        if(n==2&&m==1)return 3;
        if(n==2)return 4;
        if(m==1)return 4;
        if(m==2)return 7;
        if(m>=3)return 8;
        return 8;
    }
	
}
