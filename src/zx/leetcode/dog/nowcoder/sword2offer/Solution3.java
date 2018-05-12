package zx.leetcode.dog.nowcoder.sword2offer;

public class Solution3 {
	
	public String ReverseSentence(String str) {
		if(str.length()==1)return str;
		String[] split = str.split("\\s+");
		for(int i=0,j=split.length-1;i<j;i++,j--) {
			String temp = split[i];
			split[i] = split[j];
			split[j] = temp;
		}
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<split.length;i++) {
        	sb.append(split[i]+" ");
        }
        return sb.toString().trim();
    }
	
	public static void main(String[] args) {
		System.out.println(new Solution3().ReverseSentence(" ")+1);
	}

}
