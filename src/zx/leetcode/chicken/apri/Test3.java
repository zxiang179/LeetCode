package zx.leetcode.chicken.apri;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

/**
 * 500. Keyboard Row
 * @author Carl_Hugo
 *
 */
public class Test3 {
	
	Map<Character,Integer> map = new HashMap<Character,Integer>();
	
    public String[] findWords(String[] words) {
        init();
        String temp = "";
        String[] result = new String[words.length];
        int count=0;
        for(int i=0;i<words.length;i++){
        	temp = words[i];
        	char[] charArray = temp.toUpperCase().toCharArray();
        	int flag = 1;
        	 int s = map.get(charArray[0]);
        	for(int j=1;j<charArray.length;j++){
        		if(map.get(charArray[j])!=s){
        			flag=0;
        			break;
        		}
        	}
        	if(flag==1){
        		result[count++]=words[i];
        	}
        }
        String[] finalResult = new String[count];
        for(int i=0;i<count;i++){
        	finalResult[i]=result[i];
        }
        return finalResult;
    }
    
    public void init(){
    	map.put('Q', 1);
    	map.put('W', 1);
    	map.put('E', 1);
    	map.put('R', 1);
    	map.put('T', 1);
    	map.put('Y', 1);
    	map.put('U', 1);
    	map.put('I', 1);
    	map.put('O', 1);
    	map.put('P', 1);
    	
    	map.put('A', 2);
    	map.put('S', 2);
    	map.put('D', 2);
    	map.put('F', 2);
    	map.put('G', 2);
    	map.put('H', 2);
    	map.put('J', 2);
    	map.put('K', 2);
    	map.put('L', 2);
    	
    	map.put('Z', 3);
    	map.put('X', 3);
    	map.put('C', 3);
    	map.put('V', 3);
    	map.put('B', 3);
    	map.put('N', 3);
    	map.put('M', 3);
    	
    }

    @Test
    public void test(){
        String[] str={"Hello", "Alaska", "Dad", "Peace"};
        Test3 test3 = new Test3();
        String[] result = test3.findWords(str);
        System.out.println(result.toString());
    }
}
