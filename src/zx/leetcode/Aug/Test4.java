package zx.leetcode.Aug;
/**
 * 657. Judge Route Circle
 * @author Carl_Hugo
 * @date 2017年8月14日
 */
public class Test4 {

    /**
     *  judge if this robot makes a circle,
     *  The valid robot moves are R (Right), L (Left), U (Up) and D (down)
     * @param moves
     * @return
     */
	public boolean judgeCircle(String moves) {
        // U->hash[0] D->hash[1] L->hash[2] R->hash[3]
		int[] hash = new int[4];
		if(moves.length()%2==1)return false;
		for(int i=0;i<moves.length();i++){
			char c = moves.charAt(i);
			switch(c)
			{
				case 'U':hash[0]++;break;
				case 'D':hash[1]++;break;
				case 'L':hash[2]++;break;
				case 'R':hash[3]++;break;
			};
		}
		if(hash[0]==hash[1]&&hash[2]==hash[3])return true;
		return false;
    }

}
