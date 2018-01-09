package zx.leetcode.chicken.Aug.pingduoduo;

import java.util.Arrays;
import java.util.Scanner;

public class Main3 {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int firstLine = scanner.nextInt();
		int[] h = new int[firstLine];
		for(int i=0;i<h.length;i++){
			h[i]=scanner.nextInt();
		}
		int secondLine = scanner.nextInt();
		int[] w = new int[secondLine];
		for(int i=0;i<w.length;i++){
			w[i]=scanner.nextInt();
		}
		
		Arrays.sort(h);
	    Arrays.sort(w);
	    int i=0,j=0;
	    int count = 0;
	    for(;j<w.length&&i<h.length;j++){
	    	if(h[i]<=w[j]){
	    		count++;
	    		i++;
	    	}
	    }
	    System.out.println(count);
	}

}
