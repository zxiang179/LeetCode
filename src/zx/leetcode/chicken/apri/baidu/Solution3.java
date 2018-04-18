package zx.leetcode.chicken.apri.baidu;

public class Solution3 {

	public int[] toCompleteParallelogram(int rows, int cols, char[][] positionsInPark, int euclidX, int euclidY,
			int monteX, int monteY) {
		int[] res = new int[2];
		int p, q;
		double m_x = (double) (euclidX + monteX) * 0.5;
		double m_y = (double) (euclidY + monteY) * 0.5;
		double c_x, c_y;
		for (int r = 0; r < rows; r++) {
			for (int c = 0; c < cols; c++) {
				if ((c + 1 == euclidY && r + 1 == euclidX) || (r + 1 == monteX && c + 1 == monteY))
					continue;
				if (positionsInPark[r][c] == '+') {
					p = r + 1;
					q = c + 1;
					c_x = m_x * 2 - p;
					c_y = m_y * 2 - q;
					res[0] = (int) Math.floor(c_x);
					res[1] = (int) Math.floor(c_y);
					return res;
				}
			}
		}
		return res;
	}

}
