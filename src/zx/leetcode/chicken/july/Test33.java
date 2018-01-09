package zx.leetcode.chicken.july;

import java.util.Arrays;

/**
 * 455. Assign Cookies
 * @author Carl_Hugo
 * 2017年7月27日 下午4:40:06
 */
public class Test33 {
	
	public int findContentChildren(int[] g, int[] s) {
	    Arrays.sort(g);
	    Arrays.sort(s);
	    int i=0,j=0;
	    int count = 0;
	    for(;j<s.length&&i<g.length;j++){
	    	if(g[i]<=s[j]){
	    		count++;
	    		i++;
	    	}
	    }
	    return count;
	}

}
