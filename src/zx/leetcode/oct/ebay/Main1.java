package zx.leetcode.oct.ebay;

import java.util.Scanner;

public class Main1 {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String inputLine = scanner.nextLine();
		String[] split = inputLine.split("\\s");
		int L = Integer.valueOf(split[0]);
		int R = Integer.valueOf(split[1]);
		int W = Integer.valueOf(split[2]);
		boolean flag = true;
		for(int i=0;i<=L;i++){
			//i表示内存池中的数据比特数
			if(i<R&&L-i<W){
				flag = false;
			}
		}
		if(flag==true){
			System.out.println("OK");
		}else{
			System.out.println("DEADLOCK");	
		}
		
	}

}
