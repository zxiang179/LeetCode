package zx.leetcode.chicken.apri;

import org.junit.Test;

/**
 * 492. Construct the Rectangle
 * @author Carl_Hugo
 */
public class Test10 {
	
    private Test10 test10;

	public int[] constructRectangle(int area) {
    	int mid = (int) Math.sqrt(area);
    	int[] result = new int[2];
    	int length = 0;
    	int width = 0;
    	if(mid*mid!=area){
    		for(int i=mid;i>=1;i--){
    			length = (int)(area/i);
    			if(length*i==area){
    				width=i;
    				break;
    			}
    		}
    		result[0]=length;
    		result[1]=width;
    	}else{
        	result[0]=result[1]=mid;
        }
        return result;
    }
    
	public int[] constructRectangle2(int area) {
		int w = (int)Math.sqrt(area);
		while(area%w!=0)w--;
		return new int[]{area/w,w};
	}
	
    @Test
    public void test(){
    	Test10 test10 = new Test10();
    	int[] res=new int[2];
    	res = test10.constructRectangle2(21);
    	for(int i:res){
    		System.out.println(i);
    	}
    }

}
