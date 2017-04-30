package zx.leetcode.apri;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * 401. Binary Watch
 * @author Carl_Hugo
 */
public class Test25 {
	
	
    public List<String> readBinaryWatch(int num) {
		Map map = new HashMap<Integer,ArrayList<String>>();
        init(map);
        List resList = new ArrayList();
        resList=(ArrayList)map.get(num);
//        System.out.println(resList);
        if(resList==null)return new ArrayList();
        return resList;
    }
    
    public static void init(Map map){
    	int count=0;
    	String str="";
    	List list = null;
    	for(int i=0;i<=11;i++){
    		count=numberOf1(i);
    		for(int j=0;j<=59;j++){
    			count+=numberOf1(j);
    			if(j<10){
    	    		str=String.valueOf(i)+":0"+String.valueOf(j);
    	    	}else{
    	    		str=String.valueOf(i)+":"+String.valueOf(j);
    	    	}
    			list = (List)map.get(count);
    			if(list==null){
    				list = new ArrayList();
    				list.add(str);
    				map.put(count, list);
    			}else{
    				list.add(str);
    				map.put(count, list);	
    			}
    			count=numberOf1(i);;
    			str="";
    		}
    	}
    } 
    
    public static int numberOf1(int num){
    	int n=0;
    	while(num!=0){
    		n++;
    		num=num&(num-1);
    	}
    	return n;
    }
    
    public static void main(String[] args) {
		Test25 test25 = new Test25();
		List<String> list = new ArrayList<String>();
		list = test25.readBinaryWatch(9);
		System.out.println(list);
	}
    

}
