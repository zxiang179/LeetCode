package zx.leetcode.chicken.Aug;
/**
 * 495. Teemo Attacking
 * @author Carl_Hugo
 * @date 2017年8月31日
 */
public class Teemo_Attacking {
	
    public int findPoisonedDuration(int[] timeSeries, int duration) {
    	int coverTimes = 0;
    	for(int i=1;i<timeSeries.length;i++){
    		int gap=timeSeries[i]-timeSeries[i-1];
    		if(gap<duration){
    			coverTimes += (duration - gap); 
    		}
    	}
        return timeSeries.length*duration - coverTimes;
    }

}
