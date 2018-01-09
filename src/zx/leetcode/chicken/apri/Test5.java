package zx.leetcode.chicken.apri;

import org.junit.Test;

/**
 * 463. Island Perimeter
 * @author Carl_Hugo
 *
 */
public class Test5 {
	
	/**
	 * 遍历整个数组，如果当前值为1，则count+4，如果跟四周有相邻的边，则duplicate++，最后将count-duplicate
	 * @param grid
	 * @return
	 */
    public int islandPerimeter(int[][] grid) {
        if(grid.length==0||grid[0].length==0||grid==null)return 0;
        
        int count = 0;
        int duplicate = 0;
        for(int i=0;i<grid.length;i++){
        	for(int j=0;j<grid[0].length;j++){
        		if(grid[i][j]==1){
        			count+=4;
        		
        			if(i!=0){
            			if(grid[i-1][j]==1){
            				duplicate++;
            			}
            		}
            		if(i!=grid.length-1){
            			if(grid[i+1][j]==1){
            				duplicate++;
            			}
            		}
            		if(j!=0){
            			if(grid[i][j-1]==1){
            				duplicate++;
            			}
            		}
            		if(j!=grid[0].length-1){
            			if(grid[i][j+1]==1){
            				duplicate++;
            			}
            		}
        		}
        		
        	}
        }
        return count-duplicate;
    }
    
    @Test
    public void test(){
    	Test5 test5 = new Test5();
    	int[][] grid={{0,1,0,0},{1,1,1,0},{0,1,0,0},{1,1,0,0}};
    	System.out.println("yello strip="+test5.islandPerimeter(grid));
    }

}
