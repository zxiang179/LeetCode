package zx.leetcode.july;

/**
 * 605. Can Place Flowers
 * @author Carl_Hugo
 * @date 2017年7月5日
 */
public class Test7 {
	
	
	/**
	 * flowers cannot be planted in adjacent plots
	 * @param flowerbed
	 * @param n
	 * @return
	 */
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
    	int[] countZero = new int[flowerbed.length];
    	int flowers = 0;
    	countZero = countContinusZero(flowerbed);
    	if(flowerbed.length==1&&flowerbed[0]==0&&n==1)return true;
        for(int i=0;i<countZero.length;i++){
        	if(countZero[i]>0){
        		flowers+=(countZero[i]-1)*0.5;
        	}
        }
        return flowers>=n?true:false;
    }
    
    public int[] countContinusZero(int[] flowerbed){
    	boolean isOne = false;
    	if(flowerbed[0]==1)isOne = true;
    	int countZero = 0;
    	int[] result = new int[flowerbed.length];
    	int count = 0;
    	boolean firstIsZero = false;
    	boolean endIsZero = false;
    	//第一个数为1
    	if(isOne){
    		for(int i=1;i<flowerbed.length;i++){
        		if(flowerbed[i]==0){
        			countZero++;
        			if(i==(flowerbed.length-1)){
    					endIsZero=true;	
    					result[count++]=countZero;
            			countZero = 0;
    				}
        		}else if(flowerbed[i]==1){
        			result[count++]=countZero;
        			countZero = 0;
        		}
        	}
    	}else{
    		firstIsZero=true;
    		countZero=1;
    		for(int i=1;i<flowerbed.length;i++){
    			if(flowerbed[i]==0){
    				countZero++;
    				if(i==(flowerbed.length-1)){
    					endIsZero=true;	
    					result[count++]=countZero;
            			countZero = 0;
    				}
    			}else if(flowerbed[i]==1){
    				result[count++]=countZero;
        			countZero = 0;
    			}
    		}
    	}
    	if(firstIsZero)result[0]+=1;
    	if(endIsZero)result[count-1]+=1;
    	return result;
    }

    public static void main(String[] args) {
		System.out.println(new Test7().canPlaceFlowers(new int[]{0,0}, 2));
	}
}
