package zx.leetcode.chicken.july;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * 648. Replace Words
 * @author Carl_Hugo
 * @date 2017年7月28日
 */
public class Test34 {
	
	/**
	 * Input: dict = ["cat", "bat", "rat"]
     * sentence = "the cattle was rattled by the battery"
     * Output: "the cat was rat by the bat"
	 * @param dict
	 * @param sentence
	 * @return
	 */
    public String replaceWords(List<String> dict, String sentence) {
        if(dict.size()==0||dict==null)return sentence;
    	HashSet set = new HashSet<String>();
    	for(String s:dict){
    		set.add(s);
    	}
    	String[] splitSentence = sentence.split("\\s+");
    	StringBuilder sb = new StringBuilder();
    	for(String word: splitSentence){
    		String prefix="";
    		for(int i=1;i<=word.length();i++){
    			prefix = word.substring(0,i);
    			if(set.contains(prefix)){
    				break;
    			}
    		}
    		sb.append(" "+prefix);
    	}
        return sb.toString().trim();
    }
    
    public static void main(String[] args) {
    	String[] dictStr = {"cat", "bat", "rat"};
    	List<String> dict = Arrays.asList(dictStr);
    	String sentence = "the cattle was rattled by the battery";
		new Test34().replaceWords(dict, sentence);
	}

}
