package zx.leetcode.dog.mar;

public class Word_Search_79 {

	/**
	 * 回溯法
	 * 
	 * @param board
	 * @param word
	 * @return
	 */
	public boolean exist(char[][] board, String word) {
		if (board == null || board.length == 0 || board[0].length == 0
				|| word == null || word.length() == 0) {
			return false;
		}
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (exist(board, i, j, 0, word)) {
					return true;
				}
			}
		}
		return false;
	}

	private boolean exist(char[][] board, int i, int j, int index, String word) {
		int len = word.length();
		// 判断到字符串的最后一个字符
		if (index >= len) {
			return true;
		}
		// 判断边界
		if (i < 0 || j < 0 || i >= board.length || j >= board[0].length) {
			return false;
		}
		if (board[i][j] != word.charAt(index)) {
			return false;
		}
		char tep = board[i][j];
		board[i][j] = '#';

		boolean ret = exist(board, i-1, j, index + 1, word)
				|| exist(board, i+1, j, index + 1, word)
				|| exist(board, i, j-1, index + 1, word)
				|| exist(board, i, j+1, index + 1, word);

		//回溯
		board[i][j] = tep;
		return ret;
	}

}
