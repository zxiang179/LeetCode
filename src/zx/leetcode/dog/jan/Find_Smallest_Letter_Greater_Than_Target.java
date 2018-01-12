package zx.leetcode.dog.jan;

import org.junit.Test;

public class Find_Smallest_Letter_Greater_Than_Target {

	/**
	 * @param letters
	 * @param target
	 * @return
	 */
	public static char nextGreatestLetter(char[] letters, char target) {
		int miniNum = 53;
		int miniIndex = -1;
		int targetNum = target - 'a';
		for (int i = 0; i < letters.length; i++) {
			int letterNum1 = letters[i] - 'a';
			if (letterNum1 > targetNum) {
				if (Math.abs(letterNum1 - targetNum) <= miniNum) {
					miniNum = letterNum1 - targetNum;
					miniIndex = i;
				}
			}
		}
		for (int i = 0; i < letters.length; i++) {
			int letterNum2 = letters[i] - 'a' + 26;
			if (Math.abs(letterNum2 - targetNum) <= miniNum) {
				miniNum = letterNum2 - targetNum;
				miniIndex = i;
			}
		}
		return letters[miniIndex];
	}

	@Test
	public void test() {
		System.out
				.println(nextGreatestLetter(new char[] { 'c', 'f', 'j' }, 'k'));
	}

}
