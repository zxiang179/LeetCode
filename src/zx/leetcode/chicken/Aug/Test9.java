package zx.leetcode.chicken.Aug;

import java.util.Arrays;

/**
 * 475. Heaters
 * @author Carl_Hugo
 * @date 2017年8月18日
 */
public class Test9 {
	
	/**
	 * design a standard heater with fixed warm radius to warm all the houses.
	 * sort heaters,find the distance between the left warmer and the right warmer which is the min,record
	 * get the max distance
	 * @param houses
	 * @param heaters
	 * @return
	 */
	public int findRadius(int[] houses, int[] heaters) {
		int[] distanceArr = new int[houses.length];
		int maxRadius = Integer.MIN_VALUE;
		Arrays.sort(heaters);
		for(int i=0;i<houses.length;i++){
			int index = 0;
		    int searchRes = Arrays.binarySearch(heaters, houses[i]);
		    if(searchRes<0){
		    	index = -(searchRes+1);
			    int leftIndex = index-1;
			    int rightIndex = index;
			    if(leftIndex<0)leftIndex = 0;
			    if(rightIndex>=heaters.length-1)rightIndex=heaters.length-1;
			    distanceArr[i]=Math.min(Math.abs(houses[i]-heaters[leftIndex]), Math.abs(houses[i]-heaters[rightIndex]));
		    }else{
		    	distanceArr[i]=0;
		    }
	    }
		for(int i=0;i<distanceArr.length;i++){
			if(distanceArr[i]>maxRadius)maxRadius=distanceArr[i];
		}
	    return maxRadius;
	}
	
	public static void main(String[] args) {
		int[] houses = {1,2,3};
		int[] heaters = {2};
		System.out.println(new Test9().findRadius(houses, heaters));
		
	}

}
