package zx.leetcode.july;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 635. Design Log Storage System
 * @author Carl_Hugo
 *
 */
public class LogSystem {
	
	Map<Integer,String> map =null;
	
    public LogSystem() {
        map = new HashMap<Integer,String>();
    }
    
    public void put(int id, String timestamp) {
        map.put(id, timestamp);
    }
    
    /**
     * retrieve("2016:01:01:01:01:01","2017:01:01:23:00:00","Year"); // return [1,2,3]
     * Year:Month:Day:Hour:Minute:Second
     * @param s
     * @param e
     * @param gra
     * @return
     */
    public List<Integer> retrieve(String s, String e, String gra) {
        int x = 0;
        switch(gra){
	        case "Year":x=4;break;
	        case "Month":x=7;break;
	        case "Day":x=10;break;
	        case "Hour":x=13;break;
	        case "Minute":x=16;break;
	        case "Second":x=19;break;
        }
        s = s.substring(0,x);
        e = e.substring(0,x);
        List<Integer> resList = new ArrayList<Integer>();
        for(Integer i:map.keySet()){
        	String ss = map.get(i).substring(0,x);
        	if(ss.compareTo(s)>=0&&ss.compareTo(e)<=0)resList.add(i);
        }
        return resList;
        
    }

}
