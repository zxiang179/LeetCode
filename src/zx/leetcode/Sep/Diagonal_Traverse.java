package zx.leetcode.Sep;
/**
 * 498. Diagonal Traverse
 * @author Carl_Hugo
 * @date 2017年9月2日
 */
public class Diagonal_Traverse {
    
	public int[] findDiagonalOrder(int[][] matrix) {
		if(matrix==null)return new int[]{};
        int rows = matrix.length;
        if(rows==0)return new int[]{};
		int cols = matrix[0].length;
		int elements = rows*cols;
		int[] res = new int[elements];
		int i=0,j=0;
		int count = 0;
		//+1表示右上方 -1表示左上方
		int dir = 1;
		while(count<elements){
			if(i<0||j>cols-1){
				//箭头往右上方指
				if(i<0&&j>cols-1){
					//右上角
					i=1;
					j=cols-1;
				}else if(i<0&&j<=cols-1){
					i=0;
				}else if(i>=0&&j>cols-1){
					j = cols - 1;
					i=i+2;
				}
				dir = -1;
	        }else if(j<0||i>rows-1){
	        	//箭头往左下方指
	        	if(i>rows-1&&j<0){
	        		//左下角
	        		i = rows - 1;
	        		j = 1;
	        	}else if(j<0&&i<=rows-1){
	        		j=0;
	        	}else if(j>=0&&i>rows-1){
	        		i=rows-1;
	        		j=j+2;
	        	}
	        	dir = 1;
	        }else{
	        	if(dir>0){
	        		res[count++]=matrix[i][j];
	        		i--;
	        		j++;
	        	}else{
	        		res[count++]=matrix[i][j];
	        		i++;
	        		j--;
	        	}
	        }
		}
		System.out.println();
		return res;
	}

	
	public static void main(String[] args) {
		new Diagonal_Traverse().findDiagonalOrder(new int[][]{{2,5},{8,4},{0,-1}});
	}
}
