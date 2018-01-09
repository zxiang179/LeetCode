package zx.leetcode.chicken.Sep.netease;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	
	static List<String> list = new ArrayList<String>();
	static String input = "";
	
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		input = scanner.nextLine();
		int len = input.length();
		
        int count = len/2;  
        char str[] = new char[count*2];  
        printPar(count, count, str, 0);
        
        int maxCount = Integer.MIN_VALUE;
        int[] hash = new int[len+1];
        for(int i=0;i<list.size();i++){
        	hash[LCS_caculate(input,list.get(i))]++;
        }
        for(int i=1;i<=len;i++){
        	if(maxCount<hash[i])maxCount = hash[i];
        }
        System.out.println(maxCount);
    }
	
	public static int LCS_caculate(String s1, String s2) {
		int size1 = s1.length();
		int size2 = s2.length();
		int chess[][] = new int[s1.length() + 1][s2.length() + 1];
		for (int i = 1; i <= size1; i++) {// 根据上面提到的公式计算矩阵
			for (int j = 1; j <= size2; j++) {
				if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
					chess[i][j] = chess[i - 1][j - 1] + 1;
				} else {
					chess[i][j] = Math.max(chess[i][j - 1], chess[i - 1][j]);
				}
			}
		}
		int i = size1;
		int j = size2;
		StringBuffer sb = new StringBuffer();
		while ((i != 0) && (j != 0)) {// 利用上面得到的矩阵计算子序列，从最右下角往左上走
			if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
				sb.append(s1.charAt(i - 1));// 相同时即为相同的子串
				i--;
				j--;
			} else {
				if (chess[i][j - 1] > chess[i - 1][j]) {
					j--;
				} else {
					i--;
				}
			}
		}
		return sb.reverse().toString().length();// 记得反转
	}
	
    public static void printPar(int l, int r, char[] str, int count){  
        if(l<0 || r<l) return;  
        if(l==0&&r==0){  
        	if(!input.equals(String.valueOf(str))){
        		list.add(String.valueOf(str));
        	}
//            System.out.println(String.valueOf(str));  
        }else{  
            if(l>0){  
                str[count]='(';  
                printPar(l-1, r, str, count+1);  
            }  
            if(r>l){  
                str[count]=')';  
                printPar(l, r-1, str, count+1);  
            }  
        }  
//        System.out.println();
    }  
      
}  