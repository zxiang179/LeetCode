package zx.leetcode.dog.apri;

import java.util.Arrays;
import java.util.Comparator;

public class Largest_Number_179 {
	
	public String largestNumber(int[] nums) {
		if(nums==null||nums.length==0){
			return null;
		}
		String[] numStrArr = new String[nums.length];
		for(int i=0;i<nums.length;i++){
			numStrArr[i] = String.valueOf(nums[i]);
		}
		Arrays.sort(numStrArr, new Comparator<String>() {
			@Override
			public int compare(String a, String b) {
				return -(a+b).compareTo(b+a);
			}
		});
		StringBuilder sb = new StringBuilder();
		for(String str:numStrArr){
			sb.append(str);
		}
		while(sb.charAt(0)=='0'&&sb.length()>1){
			sb.deleteCharAt(0);
		}
        return sb.toString();
    }
	
	public static void main(String[] args) {
		new Largest_Number_179().largestNumber(new int[]{3,30,34,5,9});
	}

}
