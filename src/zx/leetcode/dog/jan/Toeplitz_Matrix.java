package zx.leetcode.dog.jan;

public class Toeplitz_Matrix {
	/**
	 * 
	 * @param matrix
	 * @return
	 */
	public boolean isToeplitzMatrix(int[][] matrix) {
		if(matrix==null||matrix[0].length==0||matrix.length==0)return false;
		for(int i=0;i<matrix.length-1;i++){
			for(int j=0;j<matrix[0].length-1;j++){
				if(matrix[i][j]!=matrix[i+1][j+1]){
					return false;
				}
			}
		}
		return true;
    }

}
