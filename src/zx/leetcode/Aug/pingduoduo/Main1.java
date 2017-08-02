package zx.leetcode.Aug.pingduoduo;

import java.util.Scanner;

public class Main1 {
	
	public static void bigNumberSimpleMulti() {  
          
        Scanner in = new Scanner(System.in);
		String str=in.nextLine();
		String[] split = str.split("\\s+");
        
        String f =split[0];
        String s =split[1];
        
        char signA = f.charAt(0);  
        char signB = s.charAt(0);  
        char sign = '+';  
        if (signA == '+' || signA == '-') {  
            sign = signA;  
            f = f.substring(1);  
        }  
        if (signB == '+' || signB == '-') {  
            if (sign == signB) {  
                sign = '+';  
            } else {  
                sign = '-';  
            }  
            s = s.substring(1);  
        }  
        // 将大数翻转并转换成字符数组  
        char[] a = new StringBuffer(f).reverse().toString().toCharArray();  
        char[] b = new StringBuffer(s).reverse().toString().toCharArray();  
        int lenA = a.length;  
        int lenB = b.length;  
        // 计算最终的最大长度  
        int len = lenA + lenB;  
        int[] result = new int[len];  
        // 计算结果集合  
        for (int i = 0; i < a.length; i++) {  
            for (int j = 0; j < b.length; j++) {  
                result[i + j] += (int) (a[i] - '0') * (int) (b[j] - '0');  
            }  
        }  
        for (int i = 0; i < result.length; i++) {  
            if (result[i] > 10) {  
                result[i + 1] += result[i] / 10;  
                result[i] %= 10;  
            }  
        }  
        StringBuffer sb = new StringBuffer();  

        boolean flag = true;  
        for (int i = len - 1; i >= 0; i--) {  
            if (result[i] == 0 && flag) {  
                continue;  
            } else {  
                flag = false;  
            }  
            sb.append(result[i]);  
        }  
        if (!sb.toString().equals("")) {  
            if (sign == '-') {  
                sb.insert(0, sign);  
            }  
        } else {  
            sb.append(0);  
        }  
        // 返回最终结果  
        System.out.println(sb.toString());  
	}
	
	public static void main(String[] args) {
		new Main1().bigNumberSimpleMulti();
	}

}
