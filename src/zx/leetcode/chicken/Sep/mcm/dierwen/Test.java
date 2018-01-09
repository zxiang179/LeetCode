package zx.leetcode.chicken.Sep.mcm.dierwen;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

public class Test {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

//        File file = new File("G:/MCM/z-f.txt");
        File file = new File("G:/MCM/getMap/i2fmap.txt");

        StringBuilder result = new StringBuilder();
        double[] resDou = new double[360];
        try{
            BufferedReader br = new BufferedReader(new FileReader(file));//构造一个BufferedReader类来读取文件
            String s = null;
            int countLine = 0;
            int count = 0;
            while((s = br.readLine())!=null){//使用readLine方法，一次读一行
                result.append(System.lineSeparator()+s);
                countLine++;
                if(s.trim()!=null||!"".equals(s.trim())){
                	String[] split = s.split("\\s");
                	System.out.print("第"+countLine+"行：   ");
                	for(int i=0;i<split.length;i++){
                		
                		System.out.print("\""+split[i]+"\""+",");
                	}
                }
                System.out.println();
            }
            br.close();
        }catch(Exception e){
            e.printStackTrace();
        }
	}

}
