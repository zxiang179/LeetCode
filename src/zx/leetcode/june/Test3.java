package zx.leetcode.june;

/**
 * 598. Range Addition II
 * @author Carl_Hugo
 * @date 2017年6月6日
 */
public class Test3 {
	
	/**
	 * @param m 初始矩阵 行数
	 * @param n 初始矩阵 列数
	 * @param ops 操作数组
	 * @return
	 */
    public int maxCount(int m, int n, int[][] ops) {
        if(ops==null||ops.length==0){
        	return m*n;
        }
        int row = Integer.MAX_VALUE;
        int col = Integer.MAX_VALUE;
        for(int[] op:ops){
        	row = Math.min(op[0], row);
        	col = Math.min(op[1], col);
        }
        return row*col;
    }

}
