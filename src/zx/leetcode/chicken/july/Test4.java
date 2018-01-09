package zx.leetcode.chicken.july;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * 22. Generate Parentheses
 * @author Carl_Hugo
 * @date 2017年7月3日
 */
public class Test4 {
	
	HashSet<String> set = new HashSet<String>();
	
    public List<String> generateParenthesis(int n) {
    	ArrayList<String> list = new ArrayList<String>();
    	if(n==0){
    		return list;
    	}
    	list.add("()");
    	for(int i=1;i<n;i++){
    		list = addList(list);
    	}
    	return list;
    }
    
    ArrayList<String> addList(List<String> list){
    	ArrayList<String> l2 = new ArrayList<String>();
    	String temp = "";
    	int size = list.size();
    	for(int i=0;i<size;i++){
    		String s = list.get(i);
    		temp = "";
    		for(int j=0;j<s.length();j++){
    			temp = s.substring(0,j)+"()"+s.substring(j);
    			if(set.add(temp)){
    				l2.add(temp);
    			}
    		}
    	}
    	return l2;
    }
    
    public static void main(String[] args) {
		new Test4().generateParenthesis(3);
	}

}
