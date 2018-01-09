package zx.leetcode.chicken.apri;
/**
 * 292. Nim Game
 * @author Carl_Hugo
 *
 */
public class Test6 {
	
	/**
	 * 当n=1 win;
	 *   n=2 win;
	 *   n=3 win;
	 *   n=4 false;
	 *   n=5 win;
	 *   n=6 win;
	 *   n=7 win;
	 *   n=8 false;
	 *   ... 
	 * @param n
	 * @return
	 */
    public boolean canWinNim(int n) {
        if(n%4==0)return false;
        return true;
    }

}
