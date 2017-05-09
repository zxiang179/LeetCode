package zx.leetcode.may;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;


/**
 * 451. Sort Characters By Frequency
 * @author Carl_Hugo
 * @date 2017年5月9日
 */
public class Test18 {
	
	/**
	 * Given a string, sort it in decreasing order based on the frequency of characters.
	 * 超时
	 * @param s
	 * @return
	 */
	public String frequencySort(String s) {
	    char[] charArray = s.toCharArray();
	    Map<Character,Integer> map = new HashMap<Character,Integer>();
	    //该字符在字符串中出现n次就在第n-1个位置
	    String[] count = new String[s.length()];
	    String res = "";
	    for(int i=0;i<charArray.length;i++){
	    	if(!map.containsKey(charArray[i])){
	    		map.put(charArray[i], 1);
	    	}else{
	    		map.put(charArray[i], map.get(charArray[i])+1);
	    	}
	    }
	    Iterator<Entry<Character, Integer>> iterator = map.entrySet().iterator();
	    while(iterator.hasNext()){
	    	String temp1= "";
	    	Entry<Character, Integer> next = iterator.next();
	    	int times = next.getValue();
	    	Character key = next.getKey();
	    	if(count[times-1]!=null){
	    		temp1 = count[times-1];
	    		temp1 += String.valueOf(key);
	    		char[] charArray2 = temp1.toCharArray();
	    		Arrays.sort(charArray2);
	    		count[times-1]=String.valueOf(charArray2);
	    	}else{
	    		count[times-1] = String.valueOf(key);
	    	}
	    }
	    for(int i=count.length-1;i>=0;i--){
	    	if(count[i]!=null){
	    		String temp2="";
	    		for(int j=0;j<=i;j++){
	    			temp2+=count[i];
	    		}
	    		char[] charArray2 = temp2.toCharArray();
    			Arrays.sort(charArray2);
    			temp2=String.valueOf(charArray2);
    			res+=temp2;
	    	}
	    }
	    return res;
	}
	
	public String frequencySort2(String s) {
		int[] hash = new int[256];
		char[] charArray = s.toCharArray();
		String[] timesArray = new String[s.length()];
		for(int i=0;i<charArray.length;i++){
			hash[charArray[i]]++;
		}
		for(int i=0;i<hash.length;i++){
			int times = hash[i];
			if(times!=0){
				char c;
				c=(char)i;
				String temp=String.valueOf(c);
				for(int j=0;j<times-1;j++){
					temp+=String.valueOf(c);
				}
				if(timesArray[times-1]!=null){
					timesArray[times-1]+=temp;
				}else{
					timesArray[times-1]=temp;
				}
			}
		}
		String res="";
		for(int i=timesArray.length-1;i>=0;i--){
			if(timesArray[i]!=null){
				res+=timesArray[i];
			}
		}
		return res;
	}
	
	
	public static void main(String[] args) {
		System.out.println(new Test18().frequencySort2("2a554442f544asfasssffffasss"));
	}
}
