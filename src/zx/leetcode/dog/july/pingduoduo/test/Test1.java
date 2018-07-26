package zx.leetcode.dog.july.pingduoduo.test;
/**
 * 螺旋矩阵
 * @author zx
 *
 */
public class Test1 {
	
	public static int[][] printMatrix(int n) {
		int[][] arr = new int[n][n];
		int base = 1;
		int i = 0;
		int j = 0;
		while(base<n*n) {
			while(j<n-1&&arr[i][j+1]==0)arr[i][j++] = base++;
			while(i<n-1&&arr[i+1][j]==0)arr[i++][j] = base++;
			while(j>0&&arr[i][j-1]==0)arr[i][j--] = base++;
			while(i>0&&arr[i-1][j]==0)arr[i--][j] = base++;
		}
		arr[n/2][n/2] = n*n;
		return arr;
	}
	
	public static void main(String[] args) {
		int n = 5;
		int[][] arr = new int[n][n];
		arr = printMatrix(n);
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	

}
