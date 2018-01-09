package zx.leetcode.chicken.may;
/**
 * 566. Reshape the Matrix
 * @author Carl_Hugo
 * @date 2017年5月4日
 */
public class Test7 {
	
	/**
	 * Input: 
     * nums = 
     * [[1,2],
     * [3,4]]
     * r = 1, c = 4
     * Output: 
     * [[1,2,3,4]]
     * Explanation:
     * The row-traversing of nums is [1,2,3,4]. 
     * The new reshaped matrix is a 1 * 4 matrix, fill it row by row by using the previous list.
	 * @param nums
	 * @param r
	 * @param c
	 * @return
	 */
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        boolean legal = ((nums.length*nums[0].length)==(r*c));
        if(legal==false)return nums;
        int m=0;
        int n=0;
        int[][] res = new int[r][c];
        for(int i=0;i<nums.length;i++){
        	for(int j=0;j<nums[0].length;j++){
        		if(n>c-1){
        			n=0;
        			m++;
        		}
        		res[m][n++]=nums[i][j];
        	}
        }
        return res;
    }

}
