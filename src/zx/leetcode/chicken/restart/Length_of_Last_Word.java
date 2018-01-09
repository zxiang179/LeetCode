package zx.leetcode.chicken.restart;

public class Length_of_Last_Word {

	public int lengthOfLastWord(String s) {
		if(s==null||s.length()==0)return 0;
		s = s.trim();
		String[] split = s.split("\\s");
		return split[split.length-1].length();
	}
}
