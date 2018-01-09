package zx.leetcode.chicken.Aug;
/**
 * 419. Battleships in a Board
 * @author Carl_Hugo
 * 2017年8月21日 下午7:06:07
 */
public class Test17 {
	
	/**
	 * 横着的X或者竖着的X表示战舰，其余情况均不是战舰
	 * @param board
	 * @return
	 */
    public int countBattleships(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        int count = 0;
        if(m==0)return 0;
        for(int i=0;i<m;i++){
        	for(int j=0;j<n;j++){
        		if(board[i][j]=='.')continue;
        		//上一行为X(因为在最初已经记录了该X，算一条船)
        		if(i>0&&board[i-1][j]=='X')continue;
        		//前一列为X，(已经记录过)
        		if(j>0&&board[i][j-1]=='X')continue;
        		count++;
        	}
        }
    	return count;
    }

}
