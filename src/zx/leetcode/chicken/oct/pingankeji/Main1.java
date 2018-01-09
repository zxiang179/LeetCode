package zx.leetcode.chicken.oct.pingankeji;

import java.util.Scanner;

public class Main1 {
	
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();

		//构建素数表
		boolean[] isComposite = new boolean[n];
		for(int i=2;i<n;i++){
			if(!isComposite[i]){
				//当前为素数
				for(int j=2;i*j<n;j++){
					isComposite[i*j]=true;
				}	
			}
		}
		
		int count = 0;
		boolean flag = false;
		for(int i=2;i<n;i++){
			if(isComposite[i]==false&&isComposite[n-i]==false){
				if(i==n-i){
					flag = true;
				}
				count++;
			}
		}
		if(flag){
			System.out.println(1+(count-1)/2);
			System.out.println(1+((count-1)>>1));
		}else{
			System.out.println(count/2);
		}
	}

}
