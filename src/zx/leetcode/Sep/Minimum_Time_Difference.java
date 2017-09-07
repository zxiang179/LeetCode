package zx.leetcode.Sep;

import java.util.ArrayList;
import java.util.List;

/**
 * 539. Minimum Time Difference
 * @author Carl_Hugo
 * 2017年9月7日 上午10:16:09
 */
public class Minimum_Time_Difference {
	
	public int findMinDifference(List<String> timePoints) {
    	int minMinutes = Integer.MAX_VALUE;
    	for(int i=0;i<timePoints.size();i++){
    		for(int j=i+1;j<timePoints.size();j++){
    			int minutes = compareMinTime(timePoints.get(i),timePoints.get(j));
    			if(minutes<minMinutes)minMinutes = minutes;
    		}
    	}
    	return minMinutes;
    }
    
    public int compareMinTime(String a,String b){
    	String[] aSplit = a.split("\\:");
    	String[] bSplit = b.split("\\:");
    	int[] aArr = new int[2];
    	int[] bArr = new int[2];
    	aArr[0] = Integer.valueOf(aSplit[0]);
    	aArr[0] = aArr[0]<12?aArr[0]+12:aArr[0];
    	
    	aArr[1] = Integer.valueOf(aSplit[1]);
    	aArr[1] = aArr[1]<12?aArr[1]+12:aArr[1];
    	
    	bArr[0] = Integer.valueOf(bSplit[0]);
    	bArr[0] = bArr[0]<12?bArr[0]+12:bArr[0];
    	
    	bArr[1] = Integer.valueOf(bSplit[1]);
    	bArr[1] = bArr[1]<12?bArr[1]+12:bArr[1];
    	
    	int diff = 0;
    	if(aArr[0]==0&&bArr[0]==0){
    		diff = Math.abs(aArr[0]*60+aArr[1]-(bArr[0]*60+bArr[1]));
    	}else if(aArr[0]==0){
    		int diff1 = Math.abs(aArr[0]*60+aArr[1]-(bArr[0]*60+bArr[1]));
    		int diff2 = Math.abs(24*60+aArr[1]-(bArr[0]*60+bArr[1]));
    		diff = Math.min(diff1, diff2);
    	}else if(bArr[0]==0){
    		int diff1 = Math.abs(aArr[0]*60+aArr[1]-(bArr[0]*60+bArr[1]));
    		int diff2 = Math.abs(aArr[0]*60+aArr[1]-(24*60+bArr[1]));
    		diff = Math.min(diff1, diff2);
    	}else{
    		diff = Math.abs(aArr[0]*60+aArr[1]-(bArr[0]*60+bArr[1]));
    	}
    	
    	return diff;
    }
    
    public static void main(String[] args) {
    	ArrayList<String> list = new ArrayList<String>();
    	list.add("01:39");
    	list.add("10:26");
    	list.add("21:43");
		System.out.println(new Minimum_Time_Difference().findMinDifference(list));
	}
    
    

}
