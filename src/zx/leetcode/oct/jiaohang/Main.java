package zx.leetcode.oct.jiaohang;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner  = new Scanner(System.in);
        String firstLine = scanner.nextLine();
        int len = Integer.valueOf(firstLine);
        int[] values = new int[len];
        String secondLine = scanner.nextLine();
        String[] split = secondLine.split("\\s");
        for(int i=0;i<split.length;i++){
        	values[i] = Integer.valueOf(split[i]);
        }
        
        //降序排列
        for (int i = 0;i < values.length;i++){
            for(int j = i;j < values.length;j++){
                if (values[i] < values[j]){
                    int temp = values[i];
                    values[i] = values[j];
                    values[j] = temp;
                }
            }
        }
        
        int money = Integer.valueOf(scanner.nextLine());
        int k = 0;
        int result=0;
        for(int i=0;i<values.length;i++){
        	while(money/values[i]!=0){
        		money-=values[i];
        		k++;
        	}
        }
        result = k;
        if(result!=0){
        	System.out.println(result);
        }else{
        	System.out.println(-1);
        }
        	
        
    }
}
