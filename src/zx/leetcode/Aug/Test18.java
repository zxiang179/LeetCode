package zx.leetcode.Aug;
/**
 * 661. Image Smoother
 * @author Carl_Hugo
 * 2017年8月22日 下午6:52:33
 */
public class Test18 {
	
	public int[][] imageSmoother(int[][] M){
		if(M==null)return new int[0][];
		int rows = M.length;
		if(rows==0)return new int[0][];
		int cols = M[0].length;
		
		int[][] res = new int[rows][cols];
		for(int i=0;i<rows;i++){
			for(int j=0;j<cols;j++){
				int count = 0;
				int sum = 0;
				for(int rowShift : new int[]{-1,0,1}){
					for(int colShift : new int[]{-1,0,1}){
						if(isValid(i+rowShift,j+colShift,rows,cols)){
							sum+=M[i+rowShift][j+colShift];
							count++;
						}
					}
				}
				res[i][j] = Math.floorDiv(sum, count);
			}
		}
		return res;
	}
	
	public boolean isValid(int row,int col,int rows,int cols){
		if(row<0||row>=rows||col<0||col>=cols){
			return false;
		}
		return true;
	}
	
	/**
	 * 方正的情况
	 * @param M
	 * @return
	 */
    public int[][] imageSmoother2(int[][] M) {
    	int m = M.length;
    	int n = M[0].length;
    	int[][] res = new int[m][n];
    	if(M==null||M[0].length==0)return res;
    	for(int i = 0;i<m;i++){
    		for(int j=0;j<n;j++){
    			if(i==0&&j==0){
    				if(m==1&&n==1){
    					res[0][0]=M[0][0];
    				}else{
    					res[0][0]=(int) Math.floorDiv(M[0][0]+M[0][1]+M[1][0]+M[1][1],4);	
    				}
    			}else if(i==0&&j==n-1){
    				res[0][n-1]=Math.floorDiv(M[0][n-1]+M[0][n-2]+M[1][n-1]+M[1][n-2], 4);
    			}else if(i==m-1&&j==0){
    				res[m-1][0]=Math.floorDiv(M[m-2][0]+M[m-2][1]+M[m-1][0]+M[m-1][1], 4);
    			}else if(i==m-1&&j==n-1){
    				res[m-1][n-1]=Math.floorDiv(M[m-2][n-2]+M[m-2][n-1]+M[m-1][n-2]+M[m-1][n-1], 4);
    			}else if(i==0){
    				res[0][j]=Math.floorDiv(M[0][j-1]+M[0][j]+M[0][j+1]+M[1][j-1]+M[1][j]+M[1][j+1], 6);
    			}else if(i==m-1){
    				res[m-1][j]=Math.floorDiv(M[m-1][j-1]+M[m-1][j]+M[m-1][j+1]+M[m-2][j-1]+M[m-2][j]+M[m-2][j+1], 6);
    			}else if(j==0){
    				res[i][0]=Math.floorDiv(M[i-1][0]+M[i][0]+M[i+1][0]+M[i-1][1]+M[i][1]+M[i+1][1], 6);
    			}else if(j==n-1){
    				res[i][n-1]=Math.floorDiv(M[i-1][n-1]+M[i][n-1]+M[i+1][n-1]+M[i-1][n-2]+M[i][n-2]+M[i+1][n-2], 6);
    			}else{
    				res[i][j]=Math.floorDiv(M[i-1][j-1]+M[i-1][j]+M[i+1][j]+M[i][j-1]+M[i][j]+M[i][j+1]+M[i+1][j-1]+M[i+1][j]+M[i+1][j+1],9);
    			}
    		}
    	}
        return res;
    }

}
