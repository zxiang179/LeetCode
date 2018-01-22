package zx.leetcode.dog.jan;

import java.util.ArrayList;
import java.util.List;

public class Partition_Labels {
	
	public List<Integer> partitionLabels(String S) {
		if(S==null||S.length()==0){
			return null;
		}
		List<Integer> list = new ArrayList<>();
		int[] map = new int[26];
		
		for(int i=0;i<S.length();i++){
			//把字符串中某一字母在该字符串中最后出现的索引记录下来
			map[S.charAt(i)-'a'] = i;
		}
		
		int last = 0;
		int start = 0;
		for(int i=0;i<S.length();i++){
			last = Math.max(last, map[S.charAt(i)-'a']);
			if(last == i){
				list.add(last-start+1);
				start = last + 1;
			}
		}
		return list;
    }
}
