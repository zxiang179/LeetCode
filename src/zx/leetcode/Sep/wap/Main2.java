package zx.leetcode.Sep.wap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Main2 {
	
	public static void main(String[] args) {
	    Scanner in = new Scanner(System.in);
	    int n, x, ans = 0;
	    n = in.nextInt();
	    int[] inputArr = new int[n];
	    for (int i = 1; i <= n; i++) {
	      x = in.nextInt();
	      inputArr[i-1]=x;
	    }
	    
	    int max = 0;
	    for(int step=2;step<=n;step++){
	    	for(int i=0;i<=n-step;i++){
	    		int greatest = 0;
	    		int secondGreatest = 0;
	    		for(int j=i;j<step+i;j++){
	    			if(inputArr[j]>greatest){
	    				secondGreatest=greatest;
	    				greatest = inputArr[j];
	    			}else if(inputArr[j]>=secondGreatest){
	    				secondGreatest = inputArr[j];
	    			}
	    		}
	    		if(max<=(greatest^secondGreatest)){
	    			max = greatest^secondGreatest;
	    		}
	    	}
	    }
	    System.out.println(max);
	    /*Arrays.sort(inputArr);
	    int one = inputArr[n-1];
	    int max = 0;
	    for(int i=0;i<n-1;i++){
    		if(max<(inputArr[i]^one)){
    			max = inputArr[i]^one;
    			System.out.println("other:"+inputArr[i]+" max:"+max);
    		}
	    }*/
	  }

}
