package zx.leetcode.chicken.Aug.netease;

import java.util.Scanner;

public class Test2 {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		//获取第一行数据
		int count = scanner.nextInt();
		int minRow=-1,minCol=-1;
		int maxRow=-1,maxCol=-1;
		//将第二行数据存放到数组中
		int[] row = new int[count];
		for(int i=0;i<row.length;i++){
			row[i]=scanner.nextInt();
			if(row[i]<minRow)minRow=row[i];
			if(row[i]>maxRow)maxRow=row[i]; 
		}
		//将第三行数据存放到数组中
		int[] col = new int[count];
		for(int i=0;i<col.length;i++){
			col[i]=scanner.nextInt();
			if(col[i]<minRow)minCol=col[i];
			if(col[i]>maxRow)maxCol=col[i];
		}		
		int[][] matrix = new int[maxRow-minRow][maxCol-minCol];
		for(int i=0;i<count;i++){
			matrix[row[i]-minRow][col[i]-minCol]++;
		}
		
		
	}

}
