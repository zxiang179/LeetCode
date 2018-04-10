package zx.leetcode.dog.apri;

public class Reverse_Words_in_a_String_151 {

	public String reverseWords(String s) {
		String[] inputStrArr = s.split("\\s+");
		StringBuilder sb = new StringBuilder();
		for (int i = inputStrArr.length - 1; i >= 0; i--) {
			if (i != 0) {
				sb.append(inputStrArr[i] + " ");
			} else {
				sb.append(inputStrArr[i]);
			}
		}
		return sb.toString().trim();
	}

	public static void main(String[] args) {
		new Reverse_Words_in_a_String_151().reverseWords("   a   b ");
	}

}
