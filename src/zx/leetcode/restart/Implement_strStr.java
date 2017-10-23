package zx.leetcode.restart;

public class Implement_strStr {
	
	public int strStr(String haystack, String needle) {
		int i = 0;
		int j = 0;
		int count = 0;
		char[] arr = haystack.toCharArray();
		char[] subArr = needle.toCharArray();
		for(i=0,j=0;i<arr.length&&j<subArr.length;){
			if(arr[i]==subArr[j]){
				i++;
				j++;
			}else{
				count++;
				j = 0;
				i = count;
			}
		}
		if(j==subArr.length){
			return count;
		}else{
			return -1;
		}
    }

}
