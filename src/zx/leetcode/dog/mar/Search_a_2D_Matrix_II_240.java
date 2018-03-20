package zx.leetcode.dog.mar;

public class Search_a_2D_Matrix_II_240 {

	/**
	 * 从右上角开始搜，根据条件判断是否删除一列或删除一行
	 * 
	 * @param matrix
	 * @param target
	 * @return
	 */
	public boolean searchMatrix(int[][] matrix, int target) {
		if (matrix == null || matrix.length == 0|| matrix[0].length==0) {
			return false;
		}
		int m = matrix.length;
		int n = matrix[0].length;
		int row = 0;
		int col = n - 1;
		while (col >= 0 && row < m) {
			if (matrix[row][col] > target) {
				col--;
			} else if (matrix[row][col] < target) {
				row++;
			} else {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		/*System.out.println(new Search_a_2D_Matrix_II_240().searchMatrix(new int[][] {
				{ 1, 4, 7, 11, 15 }, { 2, 5, 8, 12, 19 }, { 3, 6, 9, 16, 22 },
				{ 18, 21, 23, 26, 30 } }, 20));*/
		new Search_a_2D_Matrix_II_240().searchMatrix(new int[][]{{-5}}, -5);
	}
}
